package com.ambonare.TCEQForm.service;

import com.ambonare.TCEQForm.model.Form;
import com.ambonare.TCEQForm.model.OccupationalTraining;
import com.ambonare.TCEQForm.model.TypeOfLicencsApplication;
import gov.tceq.epay.webservice.epay.*;
import gov.tceq.epay.webservice.xsd.*;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.HtmlUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.*;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.*;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class FormService {
    public static Map<String, String> LICENSE_TYPES = new HashMap<String, String>();
    public String VOUCHER_NUMBER;
    private static final String PATH_SPE = PropertiesReader.getPropertie("separator");

    {
        // WATER
        LICENSE_TYPES.put("Water(D)", "WOD");
        LICENSE_TYPES.put("Water(C)Distribution", "WDC");
        LICENSE_TYPES.put("Water(B)Distribution", "WDB");
        LICENSE_TYPES.put("Water(C)Ground", "WGC");
        LICENSE_TYPES.put("Water(B)Ground", "WGB");
        LICENSE_TYPES.put("Water(C)Surface", "WSC_TYPE");
        LICENSE_TYPES.put("Water(B)Surface", "WSB");
        LICENSE_TYPES.put("Water(A)", "WOA");
        // WASTE WATER
        LICENSE_TYPES.put("Wastewater(D)", "WWD");
        LICENSE_TYPES.put("Wastewater(C)", "WWC");
        LICENSE_TYPES.put("Wastewater(B)", "WWB");
        LICENSE_TYPES.put("Wastewater(A)", "WWA");
        LICENSE_TYPES.put("Wastewater(I)Collection", "WWI");
        LICENSE_TYPES.put("Wastewater(II)Collection", "WWII");
        LICENSE_TYPES.put("Wastewater(III)Collection", "WWIII");
        // Backflow Prevention Assembly Tester
        LICENSE_TYPES.put("BPAT", "BP");
        // Customer Service Inspector
        LICENSE_TYPES.put("CSI", "CI");
        // Irrigator, Technician and Inspector
        LICENSE_TYPES.put("Irrigator", "LI");
        LICENSE_TYPES.put("IRRTechnician", "IT");
        LICENSE_TYPES.put("IRRInspector", "II");
        // Water Treatment Specialist
        LICENSE_TYPES.put("WTS(I)", "WTI");
        LICENSE_TYPES.put("WTS(II)", "WTII");
        LICENSE_TYPES.put("WTS(III)", "WTIII");
        // Municipal Solid Waste Operator
        LICENSE_TYPES.put("MSW(A)", "MSWA");
        LICENSE_TYPES.put("MSW(B)", "MSWB");
        // On-Site Sewage Systems(OSSFs), Including Septic Tanks
        LICENSE_TYPES.put("OSSF(Apprentice)", "OSAP");
        LICENSE_TYPES.put("OSSF(SiteEvaluator)", "OSSE");
        LICENSE_TYPES.put("OSSF(DesignatedRep)", "OSDR");
        LICENSE_TYPES.put("OSSF(I)", "OSI");
        LICENSE_TYPES.put("OSSF(II)", "OSII");
        LICENSE_TYPES.put("OSSF(MaintenanceProvider)", "OSMP");
        LICENSE_TYPES.put("OSSF(MaintenanceTech)", "OSMT");
        // Underground Storage Tank Contractors and On-Site Supervisors(UST)
        LICENSE_TYPES.put("UST(A)", "USA");
        LICENSE_TYPES.put("UST(B)", "USB");
        LICENSE_TYPES.put("UST(AB)", "USTAB");
        // Leaking PetroleumStorage Tank (LPST) Corrective Action Specialist and
        // Project Manager
        LICENSE_TYPES.put("LPST", "PM");
    }

    public String getLicenseType(Form form) {
        String licenseTypeCode = null;
        TypeOfLicencsApplication app = form.getTypeOfLicenseApp();
        if (app.getWaterLevel() != null) {
            switch (app.getWaterLevel()) {
                case "A":
                    licenseTypeCode = "Water(A)";
                    break;
                case "D":
                    licenseTypeCode = "Water(D)";
                    break;
                case "B":
                    if (app.getWaterType() != null) {
                        if (app.getWaterType().equals("Distribution")) {
                            licenseTypeCode = "Water(B)Distribution";
                        } else if (app.getWaterType().equals("Ground")) {
                            licenseTypeCode = "Water(B)Ground";
                        } else if (app.getWaterType().equals("Surface")) {
                            licenseTypeCode = "Water(B)Surface";
                        }
                    }
                    break;
                case "C":
                    if (app.getWaterType() != null) {
                        if (app.getWaterType().equals("Distribution")) {
                            licenseTypeCode = "Water(C)Distribution";
                        } else if (app.getWaterType().equals("Ground")) {
                            licenseTypeCode = "Water(C)Ground";
                        } else if (app.getWaterType().equals("Surface")) {
                            licenseTypeCode = "Water(C)Surface";
                        }
                    }
                    break;
                default:
                    break;
            }
        } else if (app.getWasteWater() != null) {
            switch (app.getWasteWater()) {
                case "A":
                    licenseTypeCode = "Wastewater(A)";
                    break;
                case "B":
                    licenseTypeCode = "Wastewater(B)";
                    break;
                case "C":
                    licenseTypeCode = "Wastewater(C)";
                    break;
                case "D":
                    licenseTypeCode = "Wastewater(D)";
                    break;
                case "I":
                    licenseTypeCode = "Wastewater(I)Collection";
                    break;
                case "II":
                    licenseTypeCode = "Wastewater(II)Collection";
                    break;
                case "III":
                    licenseTypeCode = "Wastewater(III)Collection";
                    break;
            }
        } else if (app.getBPAT() != null && app.getBPAT().equals("BPAT")) {
            licenseTypeCode = "BPAT";
        } else if (app.getCSI() != null && app.getCSI().equals("CSI")) {
            licenseTypeCode = "CSI";
        } else if (app.getLandscapeIrrigation() != null) {
            switch (app.getLandscapeIrrigation()) {
                case "Irrigator":
                    licenseTypeCode = "Irrigator";
                    break;
                case "Technician":
                    licenseTypeCode = "IRRTechnician";
                    break;
                case "Inspector":
                    licenseTypeCode = "IRRInspector";
                    break;
            }
        } else if (app.getWTS() != null) {
            switch (app.getWTS()) {
                case "I":
                    licenseTypeCode = "WTS(I)";
                    break;
                case "II":
                    licenseTypeCode = "WTS(II)";
                    break;
                case "III":
                    licenseTypeCode = "WTS(III)";
                    break;
            }
        } else if (app.getMSW() != null) {
            switch (app.getMSW()) {
                case "A":
                    licenseTypeCode = "MSW(A)";
                    break;
                case "B":
                    licenseTypeCode = "MSW(B)";
                    break;
            }
        } else if (app.getOSSF() != null) {
            switch (app.getOSSF()) {
                case "AP":
                    licenseTypeCode = "OSSF(Apprentice)";
                    break;
                case "DR":
                    licenseTypeCode = "OSSF(DesignatedRep)";
                    break;
                case "SE":
                    licenseTypeCode = "OSSF(SiteEvaluator)";
                    break;
                case "MP":
                    licenseTypeCode = "OSSF(MaintenanceProvider)";
                    break;
                case "MT":
                    licenseTypeCode = "OSSF(MaintenanceTech)";
                    break;
                case "I":
                    licenseTypeCode = "OSSF(I)";
                    break;
                case "II":
                    licenseTypeCode = "OSSF(II)";
                    break;
            }
        } else if (app.getUST() != null) {
            switch (app.getUST()) {
                case "A":
                    licenseTypeCode = "UST(A)";
                    break;
                case "B":
                    licenseTypeCode = "UST(B)";
                    break;
                case "Combination":
                    licenseTypeCode = "UST(AB)";
                    break;
            }
        } else if (app.getLPST() != null && app.getLPST().equals("PM")) {
            licenseTypeCode = "LPST";
        }
        return licenseTypeCode;
    }

    public FormService() {
    }

    public String createFile(Form form) throws IOException {
        // -----PARTA
        StringBuilder result = new StringBuilder();
        String NCSHeaderA = formatString("003000002001041316001   7383     1    N", 40);
        String field2 = formatString("V1APPA", 6);
        String title = formatString(form.getTitle(), 3);
        String lastName = formatString(form.getLastName(), 17);
        String field5 = formatString(11);
        String suffix = formatString(form.getPrefixOfName(), 3);
        String field7 = formatString(2);
        String firstName = formatString(form.getFirstName(), 13);
        String field9 = formatString(2);
        String mi = formatString(form.getMiddleName(), 1);
        String field11 = formatString(14);
        String water_license = formatString(form.getTypeOfLicenseApp().getWaterLevel(), 1);
        String water_type = formatString(form.getTypeOfLicenseApp().getWaterType(), 5).toUpperCase();
        // ----------
        String waste_treatment = formatString(1);
        String waste_collection = formatString(3);
        if (form.getTypeOfLicenseApp().getWasteWater() != null
                && form.getTypeOfLicenseApp().getWasteWater().indexOf("I") != -1) {
            waste_treatment = formatString(1);
            waste_collection = formatString(form.getTypeOfLicenseApp().getWasteWater(), 3);
        } else {
            waste_treatment = formatString(form.getTypeOfLicenseApp().getWasteWater(), 1);
            waste_collection = formatString(3);
        }
        // -----------
        String landscape = formatString(form.getTypeOfLicenseApp().getLandscapeIrrigation(), 5).toUpperCase();
        if (form.getTypeOfLicenseApp().getLandscapeIrrigation() != null && form.getTypeOfLicenseApp().getLandscapeIrrigation().equals("Inspector")) {
            //form.getTypeOfLicenseApp().setLandscapeIrrigation("IINSP");
            landscape = formatString("IINSP", 5);
        } else if (form.getTypeOfLicenseApp().getLandscapeIrrigation() != null && form.getTypeOfLicenseApp().getLandscapeIrrigation().equals("Technician")) {
            //form.getTypeOfLicenseApp().setLandscapeIrrigation("ITECH");
            landscape = formatString("ITECH", 5);
        }
        //landscape = formatString(form.getTypeOfLicenseApp().getLandscapeIrrigation(), 5).toUpperCase();
        String msw = formatString(form.getTypeOfLicenseApp().getMSW(), 1);
        String ust = formatString(form.getTypeOfLicenseApp().getUST(), 1);
        String wts = formatString(form.getTypeOfLicenseApp().getWTS(), 3);
        String h2_csi = formatString(form.getTypeOfLicenseApp().getCSI(), 3);
        String bpat = formatString(form.getTypeOfLicenseApp().getBPAT(), 4);
        String ossf = formatString(form.getTypeOfLicenseApp().getOSSF(), 2);
        String lpst = formatString(form.getTypeOfLicenseApp().getLPST(), 2);
        String ssn = formatString(form.getSocialSecurityNum().replace("-", "").trim(), 9);
        String regluated_entity = formatString(11);
        String reeviously_tracking = formatString(5);
        String mailing_address = formatString(form.getMailingAddress(), 45);
        String field28 = formatString(5);
        String city = formatString(form.getCity(), 25);
        String field30 = formatString(5);
        String state = formatString(form.getState().trim(), 2);
        String zipCode = formatString(form.getZipCode() + form.getZipCodePlus(), 9);
        String litho_code = formatString("ONLINE", 8);
        String LF = formatString("\r\n", 2);
        result.append(NCSHeaderA + field2 + title.toUpperCase() + lastName.toUpperCase() + field5 + suffix.toUpperCase() + field7 + firstName.toUpperCase() + field9 + mi.toUpperCase()
                + field11 + water_license + water_type + waste_treatment + waste_collection + landscape + msw + ust
                + wts + h2_csi + bpat + ossf + lpst + ssn + regluated_entity + reeviously_tracking + mailing_address.toUpperCase() + field28 + city.toUpperCase() + field30 + state.toUpperCase() + zipCode
                + litho_code + LF);
        // -------PARTB
        String NCSHeaderB = formatString("003000001001041316002   7383     1    N", 40);
        String field2B = formatString("V1APPB", 6);
        String home_phone_area_code = formatString(3);
        String home_phone_number = formatString(7);
        if (form.getHomePhoneNumber() != null && form.getHomePhoneNumber().length() >= 6) {
            home_phone_area_code = formatString(form.getHomePhoneNumber().substring(1, 4), 3);
            home_phone_number = formatString(form.getHomePhoneNumber().substring(5).replace("-", ""), 7);
        }
        String education = formatString(form.getEducationBackground().getHighestLevelOfEducation(), 5);
        String work_phone_area_code = formatString(3);
        String work_phone_number = formatString(7);
        String work_phone_extension = formatString(4);
        if (form.getWorkPhoneNumber() != null && form.getWorkPhoneNumber().length() >= 10) {
            work_phone_area_code = form.getWorkPhoneNumber().substring(1, 4);
            work_phone_number = formatString(form.getWorkPhoneNumber().substring(5).replace("-", ""), 7);
        }
        String dob_month = formatString(2);
        String dob_day = formatString(2);
        String dob_year = formatString(4);
        if (form.getBirthday() != null && form.getBirthday().length() == 10) {
            String dob = form.getBirthday().replace("/", "").replace("-", "").trim();
            dob_month = dob.substring(0, 2);
            dob_day = dob.substring(2, 4);
            dob_year = formatString(dob.substring(4), 4);
        }
        String hsged = formatString(5);
        String college = formatString(5);
        String training = formatString(5);
        String military = formatString(5);
        String reference = formatString(5);
        String out_of_state_license = formatString(5);
        String ada = formatString(3);
        String other = formatString(5);
        String compliance = formatString(3);
        String reciprocity = formatString(form.getLicensedInAnotherState(), 3).toUpperCase();
        String fee_paid = formatString("FEE", 3);
        //if license type is LPSE and Surfix is PE or PG
        if ((this.getLicenseType(form).equals("LPST") && (form.getPrefixOfName().indexOf("PE") != -1 || form.getPrefixOfName().indexOf("PG") != -1)) || form.getMilitaryVeteran().equals("YES")) {
            fee_paid = formatString(3);
        }
        String re_evaluation = formatString(3);
        String lotho_codeB = formatString("ONLINE", 8);
        String LFB = "\r\n";
        result.append(NCSHeaderB + field2B + home_phone_area_code + home_phone_number + education + work_phone_area_code
                + work_phone_number + work_phone_extension + dob_month + dob_day + dob_year + hsged + college + training
                + military + reference + out_of_state_license + ada + other + compliance + reciprocity + fee_paid + re_evaluation
                + lotho_codeB + LFB);

        return result.toString();
    }

    protected String formatString(String s, int length) {
        if (s == null) {
            s = "";
        }
        if (s.length() >= length) {
            return s.substring(0, length);
        } else {
            int emptyLength = length - s.length();
            String emptyStr = "";
            for (int i = 0; i < emptyLength; i++) {
                emptyStr += " ";
            }
            return s + emptyStr;
        }
    }

    protected String formatString(int length) {
        return formatString(null, length);
    }

    // send to ftp service...
    private FTPClient ftp;

    public Boolean ftpToServer(List<File> files) throws Exception {
        if (connect()) {
            for (File f : files)
                upload(f);
            ftp.disconnect();
            return true;
        }
        return false;
    }

    /**
     * upload file or directory
     *
     * @param file
     * @throws Exception
     */
    private void upload(File file) throws Exception {
        if (file.isDirectory()) {
            ftp.makeDirectory(file.getName());
            ftp.changeWorkingDirectory(file.getName());
            String[] files = file.list();
            for (int i = 0; i < files.length; i++) {
                File file1 = new File(file.getPath() + PATH_SPE + files[i]);
                if (file1.isDirectory()) {
                    upload(file1);
                    ftp.changeToParentDirectory();
                } else {
                    File file2 = new File(file.getPath() + PATH_SPE + files[i]);
                    FileInputStream input = new FileInputStream(file2);
                    ftp.storeFile(file2.getName(), input);
                    input.close();
                }
            }
        } else {
            FileInputStream input = new FileInputStream(file);
            if (ftp.storeFile(file.getName(), input)) {
                //
            }
            input.close();
        }
    }

    /**
     * ftp connect
     *
     * @return boolean
     * @throws IOException
     * @throws URISyntaxException
     * @throws Exception
     */
    private boolean connect() throws IOException, URISyntaxException {

        Map<String, String> ftpProperties = PropertiesReader.getPropertie();
        String ftpPath = ftpProperties.get("ftp_path");
        boolean result = false;
        ftp = new FTPClient();
        int reply;
        ftp.connect(ftpProperties.get("ftp_host"), 21);
        ftp.login(ftpProperties.get("ftp_username"), ftpProperties.get("ftp_password"));
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            return result;
        }
        if (ftp.changeWorkingDirectory(ftpPath)) {
            //
        }
        result = true;
        return result;
    }
/*
    public void testSftpUploadFile(){
        SftpConnectionFactory.createClient(endpoint,)
        SftpMessages message = new SftpMessages();
        ImmutableEndpoint endpoint;
        SftpNotifier notifier = new SftpNotifier(sftpConnector,message,endpoint,"sftpNotifier");
        SftpClient sftpClient = new SftpClient("host",notifier);
        //tftpClient.sendFile("filename",input,"host",22);
    }
*/
    // send email to user and staff use < html templates >
    public Boolean sendEmail(String userEmailAddress, String name, String subject)
            throws MessagingException, IOException, URISyntaxException {
        Map<String, String> pros = PropertiesReader.getPropertie();
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(pros.get("email_host"));
        if (!pros.get("email_port").equals("") && pros.get("email_port") != null)
            sender.setPort(Integer.parseInt(pros.get("email_port")));
        sender.setUsername(pros.get("email_username"));
        if (!pros.get("email_password").equals("") && pros.get("email_password") != null) {
            sender.setPassword(pros.get("email_password"));
        }

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper help = new MimeMessageHelper(message, true);
        help.setTo(userEmailAddress);
        help.setFrom(pros.get("email_username"));

        Resource resource = new ClassPathResource(pros.get("email_template_to_user"));
        InputStream emailTmpIS = resource.getInputStream();
        if (emailTmpIS != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(emailTmpIS));
            String line;
            StringBuilder tmplateTxt = new StringBuilder();
            while ((line = br.readLine()) != null) {
                tmplateTxt.append(line);
            }
            String contentStr = tmplateTxt.toString();
            if (subject.equals("Confirm")) {
                contentStr = name;
            } else {
                contentStr = tmplateTxt.toString().replace("${name}", name).replace("${licenseType}", subject.split("_")[0]);
            }
            help.setSubject(subject);
            help.setText(contentStr, true);
        } else {
            return false;
        }

        Properties pro = getEmailPros();
        sender.setJavaMailProperties(pro);
        sender.send(message);
        return true;
    }

    // send email to TCEQ staff.

    /**
     * @param fileNames:.dat file and attachemnts
     * @param form
     * @throws MessagingException
     * @throws URISyntaxException
     * @throws IOException
     */
    public void sendEmailToAdmin(List<String> fileNames, Form form, String folderName) throws MessagingException, IOException, URISyntaxException {
        Map<String, String> pros = PropertiesReader.getPropertie();

        //NtlmPasswordAuthentication authentication = new NtlmPasswordAuthentication("tnrcc-aus-pdc1", "srv_httpocclic", "P@ssw0rd1");
        //SmbFile filesPath = new SmbFile(path + "/", authentication);
        String licenseType = getLicenseType(form);

        String licenseDirectoryName = PropertiesReader.getPropertie(LICENSE_TYPES.get(licenseType));
        //String folderName = filesPath.getName();
        //SmbFile[] files = filesPath.listFiles();
        List<String> fileUrls = fileNames;// new ArrayList<String>();

        //String datFileName = filesPath.getName();
        //datFileName = datFileName.substring(datFileName.length() - 1) + ".dat";
        //String datFileUrl = datFileName;    // "http://" + pros.get("host_name") + "/" + pros.get("app_name") + "/download?"+ "file=" + datFileName+ "&type=" + licenseDirectoryName+"&folder=";
        String copyOfLicense = "";
        int attachmentsAmount = 0;
        StringBuilder replaceTmp = new StringBuilder();
        //if (filesPath.exists())
        {
            /*
            for (SmbFile f : files) {
                String url = f.getName();// + licenseDirectoryName;//"http://" + pros.get("host_name") + "/" + pros.get("app_name")	+ "/download?folder=" + folderName + "&file=" + f.getName() + "&type=" + licenseDirectoryName;
                if (!f.getName().startsWith("CopyOfLicense")) {
                    fileUrls.add(url);
                } else {
                    copyOfLicense = f.getName();
                }
            }
            */

            for (String u : fileUrls) {
                //String fileName = u;    // u.substring(u.indexOf("&file="),u.indexOf("&type=")).replace("&file=", "");
                if (u.startsWith("CopyOfLicense")) {
                    copyOfLicense = u;
                } else {
                    String t = "<tr><td></td><td><label>" + u + "</label></td></tr>";
                    replaceTmp.append(t);
                }
                attachmentsAmount++;
            }
        }
        String[] sentToList = pros.get("email_list").split(" ");
        JavaMailSenderImpl sender = new JavaMailSenderImpl();


        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper help = new MimeMessageHelper(message, true);
        help.setTo(sentToList);
        help.setFrom(pros.get("email_username"));

        //help.setSubject(filesPath.getName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = sdf.format(new Date());
        String mailSubject = folderName;//this.getLicenseType(form) +"_"+dateStr+"_"+form.getFirstName()+form.getLastName();
        help.setSubject(mailSubject);
        Resource resource = new ClassPathResource(PropertiesReader.getPropertie("email_template_to_admin"));
        InputStream emailTmpIS = resource.getInputStream();


        StringBuilder traningInfo = new StringBuilder("");
        for (OccupationalTraining t : form.getOccupationalTrainingList()) {
            traningInfo.append("<tr>");
            traningInfo.append("<td>");
            traningInfo.append(HtmlUtils.htmlEscape(t.getTrainingInstitution()));
            traningInfo.append("</td>");
            traningInfo.append("<td>");
            traningInfo.append(HtmlUtils.htmlEscape(t.getCourseTitle()));
            traningInfo.append("</td>");
            traningInfo.append("<td>");
            traningInfo.append(HtmlUtils.htmlEscape(t.getLocation()));
            traningInfo.append("</td>");
            traningInfo.append("<td>");
            traningInfo.append(HtmlUtils.htmlEscape(t.getTrainingDate()));
            traningInfo.append("</td>");
            traningInfo.append("<td>");
            traningInfo.append(HtmlUtils.htmlEscape(t.getCreditHours()));
            traningInfo.append("</td>");
            traningInfo.append("</tr>");
        }

        if (emailTmpIS != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(emailTmpIS));
            String line;
            StringBuilder tmplateTxt = new StringBuilder();
            while ((line = br.readLine()) != null) {
                tmplateTxt.append(line);
            }
            String tmp = tmplateTxt.toString();
            //----
            String attachementsDescription = "";
            attachementsDescription = form.getAttachementsDescription();
            if (!form.getAttachementsDescriptionAnother().equals("")) {
                attachementsDescription += "," + form.getAttachementsDescriptionAnother();
            }
            //----
            String licensedInAnotherState = form.getLicensedInAnotherState();
            /*
            if (licensedInAnotherState.equalsIgnoreCase("YES")){
                licensedInAnotherState = "RECIPROCITY";
            }*/
            tmp = tmp.replace("${.dat}", HtmlUtils.htmlEscape(folderName)).replace("${DatFileName}", HtmlUtils.htmlEscape(folderName))
                    .replace("${attachementsDescription}", HtmlUtils.htmlEscape(attachementsDescription))
                    .replace("${attachemntUrls}", replaceTmp)
                    .replace("${copyOfLicense}", copyOfLicense)
                    .replace("${attachemntsAmount}", String.valueOf(attachmentsAmount))
                    .replace("${namePrefix}", form.getTitle()).replace("${firstName}", HtmlUtils.htmlEscape(form.getFirstName()))
                    .replace("${middleName}", HtmlUtils.htmlEscape(form.getMiddleName())).replace("${lastName}", HtmlUtils.htmlEscape(form.getLastName()))
                    .replace("${nameSuffix}", form.getPrefixOfName()).replace("${SSN}", "***-**-" + form.getSocialSecurityNum().substring(7))
                    .replace("${dateOfBirth}", "**/**/" + form.getBirthday().substring(6)).replace("${customerRole}", form.getCustomerRole())
                    .replace("${owershipType}", form.getTypeOfCustomer())
                    .replace("${address}", HtmlUtils.htmlEscape(form.getMailingAddress())).replace("${city}", HtmlUtils.htmlEscape(form.getCity()))
                    .replace("${state}", form.getState())
                    .replace("${zipCode}", form.getZipCode() + form.getZipCodePlus())
                    .replace("${homePhone}", form.getHomePhoneNumber())
                    .replace("${workPhone}", form.getWorkPhoneNumber()).replace("${workEmail}", form.getWorkEmail())
                    .replace("${licenseType}", "" + getLicenseType(form)).replace("${licenseLevel}", "")
                    .replace("${applicationType}", "").replace("${appliedDate}", form.getAffiadavit().getDate())
                    .replace("${licensedInAnotherState}", licensedInAnotherState)
                    .replace("${applicationForReciprocity.type}", HtmlUtils.htmlEscape(form.getApplicationForReciprocity().getType()))
                    .replace("${applicationForReciprocity.issuingStateOrCountry}",
                            HtmlUtils.htmlEscape(form.getApplicationForReciprocity().getIssuingStateOrCountry()))
                    .replace("${applicationForReciprocity.issueDate}",
                            form.getApplicationForReciprocity().getIssueDate())
                    .replace("${applicationForReciprocity.expirationDate}",
                            form.getApplicationForReciprocity().getExpirationDate())
                    .replace("${attachedCopyofLicensePath}", "attachedCopyofLicensePath")// -----
                    .replace("${currentMaillingAddress}", HtmlUtils.htmlEscape(form.getCurrentMaillingAddress()))
                    /*replace("${country}", form.getCountry()).replace("${maillingZone}", form.getMaillingZone())
					.replace("${mailingCode}", form.getMailingCode())
					.replace("${postalFeatures}", form.getPostalFeatures())*/
                    .replace("${occupationalLicenses.type}", HtmlUtils.htmlEscape(form.getOccupationalLicenses().getType()))
                    .replace("${occupationalLicenses.issuingAgency}", HtmlUtils.htmlEscape(form.getOccupationalLicenses().getIssuingAgency()))
                    .replace("${occupationalLicenses.issuanceDate}", form.getOccupationalLicenses().getIssuanceDate())
                    .replace("${occupationalLicenses.expirationDate}",
                            form.getOccupationalLicenses().getExpirationDate())
                    .replace("${educationBackground.educationYearOfGraduation}",
                            form.getEducationBackground().getEducationYearOfGraduation())
                    .replace("${educationBackground.numberOfSemesterhours}",
                            form.getEducationBackground().getNumberOfSemesterhours())
                    .replace("${educationBackground.highestLevelOfEducation}",
                            form.getEducationBackground().getHighestLevelOfEducation())
                    .replace("${educationBackground.collegeName}", HtmlUtils.htmlEscape(form.getEducationBackground().getCollegeName()))
                    .replace("${educationBackground.major}", HtmlUtils.htmlEscape(form.getEducationBackground().getMajor()))
                    .replace("${affidavit.signature}", HtmlUtils.htmlEscape(form.getAffiadavit().getSignature()))
                    .replace("${affidavit.affidavit}", form.getAffiadavit().getAffidavit())
                    .replace("${affidavit.date}", form.getAffiadavit().getDate())
                    .replace("${trainingInfos}", traningInfo.toString())
                    .replace("${cellPhone}", form.getCellPhoneNumber())
                    .replace("${personalEmail}", form.getPersonalEmail())
                    .replace("${voucherNumber}", form.getVoucherNumber())
                    .replace("${militaryVeteran}", form.getMilitaryVeteran())
                    .replace("${insideUS}", form.getInsideUS());
            help.setText(tmp, true);
        } else {

        }
        sender.setHost(pros.get("email_host"));
        sender.setUsername(pros.get("email_username"));
        if (!pros.get("email_port").equals("") && pros.get("email_port") != null)
            sender.setPort(Integer.parseInt(pros.get("email_port")));
        sender.setUsername(pros.get("email_username"));
        if (!pros.get("email_password").equals("") && pros.get("email_password") != null) {
            sender.setPassword(pros.get("email_password"));
        } else {
            sender.setPassword("");
        }

        Properties pro = getEmailPros();
        sender.setJavaMailProperties(pro);
        sender.send(message);
    }

    private Properties getEmailPros() {
        Properties pro = new Properties();
        pro.put("mail.transport.protocol", "smtp");
        pro.put("mail.smtp.starttls.enable", "true");
        pro.put("mail.smtp.auth", "false");
        pro.put("mail.smtp.ehlo", "false");
        //pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.timeout", 25000);
        return pro;
    }

    public String saveForm(String formFileContent, String licensType, String firstAndLastName, String suffix, Form form) throws IOException, URISyntaxException {
        String directoryName = PropertiesReader.getPropertie(LICENSE_TYPES.get(licensType));
        String folderName = licensType;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = sdf.format(new Date());
        //If license type is lpst and suffix include PE or PG, the file name need append (PE/PG).
        if (licensType.equals("LPST") && (suffix.indexOf("PE") != -1 || suffix.indexOf("PG") != -1)) {
            folderName += "(" + suffix + ")" + "_" + dateStr +"_"  + firstAndLastName;
        } else {
            folderName += "_" + dateStr + "_"+ firstAndLastName;
        }

        //this.saveSmbFile(directoryName,folderName,formFileContent,form);
        this.saveSftpFile(directoryName,folderName,formFileContent,form,null,null);

        if (form.getUSTBFiles().equals("true")) {
            form.setUSTBFiles(folderName);
        }

        return folderName;
    }

    public List<String> saveAttachement(MultipartHttpServletRequest request, String folderName, String licenseType, Form form, String licensType)
            throws IllegalStateException, IOException {
        List<String> fileNames = new ArrayList<String>();
        String directoryName = PropertiesReader.getPropertie(LICENSE_TYPES.get(licensType));
        Iterator<String> files = request.getFileNames();
        int id = 1;
        while (files.hasNext()) {
            MultipartFile f = request.getFile(files.next());
            if (f != null) {
                String filename = f.getOriginalFilename();
                if (!filename.equals("")) {
                    String surfix = "";
                    if (filename.indexOf(".") != -1) {
                        String temp[] = filename.split("\\.");
                        surfix = "." + temp[temp.length - 1];
                    }
                    String newFileName = licenseType + "_" + id;
                    if (f.getName().equals("licenseCopyFile")) {
                        newFileName = "CopyOfLicense_" + licenseType + "_" + id;
                    }
                    if (!form.getUSTAFiles().equals("") && !form.getUSTAFiles().equals("true")) {
                        newFileName = newFileName.replace("(A)", "(B)");
                    }
                    this.saveSftpFile(directoryName,folderName,f,form,newFileName,surfix);
                    fileNames.add(newFileName+surfix);
                    id++;
                }
            }
        }

        if (form.getUSTAFiles().equals("true")) {
            form.setUSTAFiles(folderName);
        }

        return fileNames;
    }

    public String saveLocalFile() {
        String localFilePath = "";
        return localFilePath;
    }

    public String saveSftpFile(String directoryName, String folderName, Object formFileOrContent, Form form, String prefix, String suffix){
        String message = "";
        String fileNamePrefix = folderName;
        String fileNameSuffix = ".dat";
        String remoteDirectoryName = directoryName;
        if (prefix!=null&&suffix!=null){
            fileNamePrefix = prefix;
            fileNameSuffix = suffix;
            if (folderName.equals("log")){
                remoteDirectoryName = "log";
            }else {
                remoteDirectoryName += "/" + folderName;
            }
        }
        message += "remoteDirectoryName:" + remoteDirectoryName +"<br>";
        File file =  this.createTempFile(fileNamePrefix,fileNameSuffix,formFileOrContent);

        if (file!=null){
            List<File> files = new ArrayList<File>();
            files.add(file);
            message += this.uploadSFTPFile(files,remoteDirectoryName);
        }
        return message;
    }

    public File createTempFile(String prefix, String suffix, Object contentOrFile){
        try {
            File tempFile = File.createTempFile(prefix, suffix);

            String tempFolder=System.getProperty("java.io.tmpdir");
            File destFile = new File(tempFolder + PATH_SPE + prefix + suffix);

            FileOutputStream fos = new FileOutputStream(tempFile);

            if (contentOrFile instanceof MultipartFile){
                MultipartFile multipartFile = (MultipartFile)contentOrFile;
                fos.write(multipartFile.getBytes());
            }else if (contentOrFile instanceof String){
                String content = (String)contentOrFile;
                fos.write(content.getBytes());
            }
            fos.flush();
            fos.close();

            tempFile.renameTo(destFile);

            return destFile;

        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public String saveSmbFile(String directoryName, String folderName, Object formFileOrContent, Form form) {
        String errMessage = "";

        String url = PropertiesReader.getPropertie("form_path") + directoryName;    //"smb://TCEQ4AVMAPP4/OOW_PRS_occlic_uploads/www20tst_uploads/";
        NtlmPasswordAuthentication authentication = new NtlmPasswordAuthentication("tnrcc-aus-pdc1", "srv_httpocclic", "P@ssw0rd1");
        try {
            SmbFile file = new SmbFile(url, authentication);
            if (!file.exists()) {
                file.mkdir();
            }
            String formName = url + PATH_SPE + folderName + ".dat";
            System.out.println(formName);
            SmbFile f = new SmbFile(formName, authentication);
            if (!f.exists()) {
                f.createNewFile();
            }

            SmbFileOutputStream out = new SmbFileOutputStream(f);

            if (formFileOrContent instanceof MultipartFile){
                MultipartFile multipartFile = (MultipartFile)formFileOrContent;
                out.write(multipartFile.getBytes());
            }else if (formFileOrContent instanceof String){
                String formFileContent = (String)formFileOrContent;
                out.write(formFileContent.getBytes());
            }
            out.close();
            return file.getPath() + PATH_SPE + folderName;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return errMessage;
    }

    public String uploadSFTPFile(List<File> files, String folder){
        SFTPUtil ftp= new SFTPUtil();
        String message = ftp.connect();
        message += ftp.upload(files,folder);
        message += ftp.disconnect();
        return message;
    }

    public String testSftpHost(){
        String message = "";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            String hostName = ip.getHostName();
            //String hostNameUpper = hostName.toUpperCase();
            message += "host name:" + hostName + "<br>";

        }catch (UnknownHostException ex){
            System.out.println(ex.getMessage());
            message += ex.getMessage();
        }
        return message;
    }

    public String testSftpFile(){
        String message = "";
        File file = this.createTempFile("tmp",".txt","test sftpfile content");
        message += file.getAbsolutePath()+"<br>";
        List<File> files = new ArrayList<File>();
        files.add(file);
        /*
        Map<String, String> sftpProperties = PropertiesReader.getPropertie();
        String sftpKnownHostKeyFilePath = sftpProperties.get("sftp_known_hosts_key_path");
        File hostFile = new File(sftpKnownHostKeyFilePath);
        files.add(hostFile);

        String sftpPrivateKeyFilePath = sftpProperties.get("sftp_private_key_path");
        File keyFile = new File(sftpPrivateKeyFilePath);
        files.add(keyFile);
        */
        String directoryName = "tmp";
        message += "<br>uploadSFTPFile message:" + this.uploadSFTPFile(files,directoryName) + "<br>";
        //message = this.saveSftpFile(directoryName,"tmp",file,null,"updatefilename","surfix");

        return message;
    }

    public EpayPortType currentEnvironmentEpayPortType(){

        EpayService epayService = new EpayService();
        EpayPortType epayPortType = epayService.getEpayPort();

        String prd1ServerUrl = "http://intwsprd1.tceq.texas.gov:8080/axis2/services/EpayService";
        String dev1ServerUrl = "http://intwsdev.tceq.texas.gov:8080/axis2/services/EpayService";
        boolean isEpayServiceIntwsprd1 = PropertiesReader.getPropertie("Epay_Service_Url").equalsIgnoreCase(prd1ServerUrl);
        boolean isEpayServiceIntwsdev1 = PropertiesReader.getPropertie("Epay_Service_Url").equalsIgnoreCase(dev1ServerUrl);

        if (isEpayServiceIntwsprd1){
            EpayServicePrd1 epayServicePrd1 = new EpayServicePrd1();
            epayPortType = epayServicePrd1.getEpayPort();
        }else if (isEpayServiceIntwsdev1){
            EpayServiceDev epayServiceDev = new EpayServiceDev();
            epayPortType = epayServiceDev.getEpayPort();
        }
        return epayPortType;
    }

    public String vourcherNumberChecker(String vourcherNumber, String amount) throws RemoteException, ErrorResponse {
        vourcherNumber = vourcherNumber.trim();

        EpayPortType epayPortType = this.currentEnvironmentEpayPortType();
        EpayGetStatusByVoucher epayGetStatusByVoucher = new EpayGetStatusByVoucher();
        Header header = new Header();
        header.setVersion("1.0");
        GregorianCalendar cal = new GregorianCalendar();
        Date date = new Date();
        cal.setTime(date);
        XMLGregorianCalendar gc = null;
        try {
            gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            header.setTimestamp(gc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        epayGetStatusByVoucher.setHeader(header);

        UserInfo userInfo = new UserInfo();
        userInfo.setCallingApplication("?");
        userInfo.setIdaUserName("?");
        epayGetStatusByVoucher.setUserInfo(userInfo);

        VoucherArray voucherArray = new VoucherArray();
        voucherArray.getVoucherNumber().add(vourcherNumber);

        epayGetStatusByVoucher.setVoucherNumberList(voucherArray);
        EpayGetStatusByVoucherResponse epayGetStatusByVoucherResponse = epayPortType
                .epayGetStatusByVoucher(epayGetStatusByVoucher);
        GetStatusByVoucherResponseInfoArray statusArray = epayGetStatusByVoucherResponse
                .getGetStatusByVoucherResponseInfoArray();
        if (statusArray != null) {
            List<GetStatusByVoucherResponseInfo> infos = statusArray.getGetStatusByVoucherResponseInfo();
            for (GetStatusByVoucherResponseInfo info : infos) {
                float fee = Float.parseFloat(info.getFeeAmount());
                DecimalFormat decimalFormat = new DecimalFormat(".00");
                String feeStr = decimalFormat.format(fee);
                if (info.getVoucherStatus().equals("UNAPPLIED")||info.getVoucherStatus().equals("AVAILABLE")) {
                    if (!feeStr.equals(amount)) {
                        return "Amount does not match license type, please contact TCEQ staff at phone: 512-239-6133.";
                    }else {
                        VOUCHER_NUMBER = vourcherNumber;
                        return "SUCCESS";
                    }
                }
                /*
                if (info.getVoucherStatus().equals("APPLIED")) {
                    return "Voucher number was used.";
                }*/
            }
        }
        return "The voucher number cannot be used.";//"The entered Voucher Number is not valid. Please verify and re-enter the correct Voucher Number.";
    }

    public String updateVourcherNumberStatus(String voucherNumber, String status)
            throws RemoteException, ErrorResponse {
        EpayPortType epayPortType = this.currentEnvironmentEpayPortType();
        EpayUpdateVoucherStatus epayUpdateVoucherStatus = new EpayUpdateVoucherStatus();
        Header header = new Header();
        header.setVersion("1.0");
        GregorianCalendar cal = new GregorianCalendar();
        Date date = new Date();
        cal.setTime(date);
        XMLGregorianCalendar gc = null;
        try {
            gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            header.setTimestamp(gc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        epayUpdateVoucherStatus.setHeader(header);

        UserInfo userInfo = new UserInfo();
        userInfo.setCallingApplication("?");
        userInfo.setIdaUserName("?");
        epayUpdateVoucherStatus.setUserInfo(userInfo);

        UpdateVoucherStatusInputArray updateVoucherStatusInputArray = new UpdateVoucherStatusInputArray();
        UpdateVoucherStatusInfo updateVoucherStatusInfo = new UpdateVoucherStatusInfo();
        updateVoucherStatusInfo.setVoucherNumber(voucherNumber);
        updateVoucherStatusInfo.setVoucherStatus(status);
        updateVoucherStatusInfo.setStatusComment("update status to APPLED");
        updateVoucherStatusInfo.setSteersProgram("?");
        updateVoucherStatusInfo.setSteersRefNum("?");
        updateVoucherStatusInputArray.getUpdateVoucherStatusInput().add(updateVoucherStatusInfo);
        epayUpdateVoucherStatus.setUpdateVoucherStatusInput(updateVoucherStatusInputArray);
        EpayUpdateVoucherStatusResponse epayUpdateVoucherStatusResponse = epayPortType
                .epayUpdateVoucherStatus(epayUpdateVoucherStatus);
        UpdateVoucherStatusOutputArray statusArray = epayUpdateVoucherStatusResponse.getUpdateVoucherStatusOutput();
        if (statusArray != null) {
            List<UpdateVoucherStatusInfo> infos = statusArray.getUpdateVoucherStatusOutput();
            for (UpdateVoucherStatusInfo info : infos) {
                if (info.getVoucherNumber().equals(voucherNumber)) {
                    return "SUCCESS";
                }
            }
        }
        return "update status failure";
    }

    public void log(String msg, String licensType, String folderName, Form form) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        //String logFileNameStr = "logMsg" + sdf.format(new Date()) + ".log";

        //File logFile = this.createTempFile(logFileNameStr,".log",msg);
        String directoryName = PropertiesReader.getPropertie(LICENSE_TYPES.get(licensType));
        /*
        NtlmPasswordAuthentication authentication = new NtlmPasswordAuthentication("tnrcc-aus-pdc1", "srv_httpocclic", "P@ssw0rd1");
        String logFolderStr = PropertiesReader.getPropertie("form_path") + "logs/";//PropertiesReader.getPropertie("log_path");
        SmbFile logFolder = new SmbFile(logFolderStr, authentication);
        if (!logFolder.exists()) {
            logFolder.mkdir();
        }


        //File logFileName = new File(logStr);
        SmbFile logFileName = new SmbFile(logStr, authentication);
        if (!logFileName.exists()) {
            logFileName.createNewFile();
        }

        SmbFileOutputStream out = new SmbFileOutputStream(logFileName, true);
        sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String log = sdf.format(new Date()) + ":\t" + msg;
        out.write(log.getBytes());
        out.close();
        */
        this.saveSftpFile(directoryName,"log",msg,form,"logMsg"+folderName+sdf.format(new Date()),".log");
    }

    public String postFileToServer(String content) {
        String message = "";
        try {
            X509TrustManager tm = new TrustAnyTrustManager();
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{tm}, new java.security.SecureRandom());
            CredentialsProvider credsProvider = new BasicCredentialsProvider();
            UsernamePasswordCredentials usernamePasswordCredentials = new UsernamePasswordCredentials("srv_httpocclic", "P@ssw0rd1");
            credsProvider.setCredentials(AuthScope.ANY, usernamePasswordCredentials);

            CloseableHttpClient httpclient = HttpClients.custom().setSSLHostnameVerifier(new TrustAnyHostnameVerifier()).setSSLContext(sslContext).setDefaultCredentialsProvider(credsProvider).build(); // HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://tceq4avmapp4.tceq.texas.gov/occlic_uploads/");

            CloseableHttpResponse response = httpclient.execute(httpGet);
            String headerStr = response.getAllHeaders().toString();
            //String responseBody = response.
            HttpEntity resEntity = response.getEntity();
            String resStr = EntityUtils.toString(resEntity);
            message += "Http Get Test:<br>response.toString:" + response.toString() + "<br>headers:" + headerStr + "<br>resStr:" + resStr + "<br><br><br>";
            EntityUtils.consume(resEntity);

            HttpPost httpPost = new HttpPost("https://tceq4avmapp4.tceq.texas.gov/occlic_uploads/");
            httpPost.setHeader("Content-Type", "multipart/form-data");

            File tempFile = createTempFile("tmp",".txt",content);
            FileEntity fileEntity = new FileEntity(tempFile);
            httpPost.setEntity(fileEntity);
            message += "Http Post1 Test:<br>tempFile:" + tempFile.getAbsolutePath() + "<br>file content:" + content + "<br>";
            response = httpclient.execute(httpPost);
            resEntity = response.getEntity();
            resStr = EntityUtils.toString(resEntity);
            message += "response.toString:" + response.toString() + "<br>headers:" + headerStr + "<br>resStr:" + resStr + "<br><br><br>";
            EntityUtils.consume(resEntity);

            FileBody bin = new FileBody(tempFile);
            HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("fileUpload", bin).build();
            httpPost.setEntity(reqEntity);
            response = httpclient.execute(httpPost);
            resEntity = response.getEntity();
            resStr = EntityUtils.toString(resEntity);
            message += "Http Post2 Test:<br>response.toString:" + response.toString() + "<br>headers:" + headerStr + "<br>resStr:" + resStr + "<br>";
            EntityUtils.consume(resEntity);

        } catch (IOException e) {
            e.printStackTrace();
            message = message + e.getMessage() + "<br>";
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            message = message + ex.getMessage() + "<br>";
        } catch (KeyManagementException kmex) {
            kmex.printStackTrace();
            message = message + kmex.getMessage() + "<br>";
        } finally {

        }
        return message;
    }

    private static class TrustAnyTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

}
