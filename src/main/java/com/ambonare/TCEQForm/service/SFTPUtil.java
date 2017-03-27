package com.ambonare.TCEQForm.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import com.jcraft.jsch.*;

import java.util.Map;

public class SFTPUtil {

    private ChannelSftp sftp = null;
    private Session sftpSession = null;
    private String remotePath = "/www20tst_uploads/";

    /**
     * connect server via sftp
     */
    public String connect() {
        String message = "";
        Map<String, String> sftpProperties = PropertiesReader.getPropertie();
        this.remotePath = sftpProperties.get("sftp_path");
        String host = sftpProperties.get("sftp_host");
        String username = sftpProperties.get("sftp_username");
        String password = sftpProperties.get("sftp_password");
        int port = Integer.parseInt(sftpProperties.get("sftp_port"));

        try {
            if(sftp != null){
                message += "sftp is not null";
            }
            JSch jsch = new JSch();
            String sftpKnownHostKeyFilePath = sftpProperties.get("sftp_known_hosts_key_path");
            jsch.setKnownHosts(sftpKnownHostKeyFilePath);
            String sftpPrivateKeyFilePath = sftpProperties.get("sftp_private_key_path");
            jsch.addIdentity(sftpPrivateKeyFilePath);
            jsch.getSession(username, host, port);
            //UserInfo userInfo = ne
            //HostKey hostKey = new HostKey()
            //jsch.getHostKeyRepository().add(hostKey,userInfo);
            Session sshSession = jsch.getSession(username, host, port);
            sftpSession = sshSession;
            message += "Session created.";
            //sshSession.setHostKeyAlias();
            //sshSession.setHostKeyRepository();
            //sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            //sshConfig.put("StrictHostKeyChecking", "no");
            sshConfig.put("StrictHostKeyChecking", "yes");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            message += "Session connected.";
            message += "Opening Channel.";
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            message += "Connected to " + host + ".";
        } catch (Exception e) {
            e.printStackTrace();
            message += e.getMessage();
        }
        return message;
    }
    /**
     * Disconnect with server
     */
    public String disconnect() {
        String message = "";
        if(this.sftp != null){
            if(this.sftp.isConnected()){
                this.sftp.disconnect();
            }else if(this.sftp.isClosed()){
                message += "sftp is closed already" + "<br>";
            }
        }
        if (this.sftpSession!=null){
            if (this.sftpSession.isConnected()){
                this.sftpSession.disconnect();
            }else {
                message += "sftpSession is closed already" + "<br>";
            }
        }
        return message;
    }
    /**
     * upload all the files to the server
     */
    public String upload(List<File> files, String folder) {
        String message = "";
        try {
            for (File file : files) {
                if(file.isFile()){
                    message += "localFile : " + file.getAbsolutePath();
                    String remoteFile = this.remotePath;
                    if (folder.length()>0) {
                        remoteFile += folder + "/";
                    }
                    remoteFile += file.getName();
                    message += "remotePath:" + remoteFile;
                    //File rfile = new File(remoteFile);
                    //String rpath = rfile.getParent();
                    String rpath = this.remotePath + folder;
                    try {
                        createDir(rpath, sftp);
                    } catch (Exception e) {
                        message += "*******create path failed" + rpath;
                    }
                    this.sftp.put(new FileInputStream(file), file.getName());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            message += e.getMessage() + "<br>";
        } catch (SftpException e) {
            e.printStackTrace();
            message += e.getMessage()  + "<br>";
        }
        return message;
    }

    /**
     * 创建一个文件目录
     */
    public void createDir(String createpath, ChannelSftp sftp) throws SftpException {
        try {
            if (isDirExist(createpath)) {
                this.sftp.cd(createpath);
                return;
            }
            String pathArry[] = createpath.split("/");
            StringBuffer filePath = new StringBuffer("/");
            for (String path : pathArry) {
                if (path.equals("")) {
                    continue;
                }
                filePath.append(path + "/");
                if (isDirExist(filePath.toString())) {
                    sftp.cd(filePath.toString());
                } else {
                    // 建立目录
                    sftp.mkdir(filePath.toString());
                    // 进入并设置为当前目录
                    sftp.cd(filePath.toString());
                }
            }
            this.sftp.cd(createpath);
        } catch (SftpException e) {
            //throw new SystemException("创建路径错误：" + createpath);
            throw e;
        }
    }

    /**
     * 判断目录是否存在
     */
    public boolean isDirExist(String directory) {
        boolean isDirExistFlag = false;
        try {
            SftpATTRS sftpATTRS = sftp.lstat(directory);
            isDirExistFlag = true;
            return sftpATTRS.isDir();
        } catch (Exception e) {
            if (e.getMessage().toLowerCase().equals("no such file")) {
                isDirExistFlag = false;
            }
        }
        return isDirExistFlag;
    }
}