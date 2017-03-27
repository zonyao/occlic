package com.ambonare.TCEQForm.controller;

import com.ambonare.TCEQForm.model.Form;
import com.ambonare.TCEQForm.model.TypeOfLicencsApplication;
import com.ambonare.TCEQForm.service.FormService;
import com.ambonare.TCEQForm.service.GlobalConstant;
import com.ambonare.TCEQForm.service.PropertiesReader;
import gov.tceq.epay.webservice.epay.ErrorResponse;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URISyntaxException;
import java.rmi.RemoteException;
import java.util.*;


/**
 *
 * @author lin
 *
 */
@Controller
public class FormController {
	@Autowired
	private  FormService formService;
	private static Map<String,String> props ;
	private Map<String,String> confirmCodeMap=null;
	static String PATH = "/";
	static{
		props = PropertiesReader.getPropertie();
		PATH=props.get("separator");
	}

	/**
	 * Download file form server.
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@RequestMapping(value="/download/{file}",method=RequestMethod.GET)
	public ResponseEntity<byte[]>  getFile(@PathVariable String file, Model model) throws IOException, URISyntaxException{
		String tempFolder=System.getProperty("java.io.tmpdir");
		String sftpKeyPath = props.get("sftp_key_path");
		String fullPath = tempFolder +PATH+file;
		File f = new File(fullPath);
		HttpHeaders head = new HttpHeaders();
		head.setContentDispositionFormData("attachments", file);
		head.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		if (f.exists()){
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(f),head,HttpStatus.CREATED);
		}else {
			fullPath = sftpKeyPath + file;
			f = new File(fullPath);
			if (f.exists()){
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(f),head,HttpStatus.CREATED);
			}else {
				String errMsg = "Sorry, can not find this file:" + fullPath;
				return new ResponseEntity<byte[]>(errMsg.getBytes("UTF8"),head,HttpStatus.CREATED);
			}
		}
	}
	@RequestMapping(value="/download1",method=RequestMethod.GET)
	public ResponseEntity<byte[]>  getFile1() throws IOException {
		String fileName = "id_rsa";
		String sftpKeyPath = props.get("sftp_key_path");
		String fullPath = sftpKeyPath + fileName;
		File f = new File(fullPath);
		HttpHeaders head = new HttpHeaders();
		head.setContentDispositionFormData("attachments", fileName);
		head.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		if (f.exists()){
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(f),head,HttpStatus.CREATED);
		}else {
			String errMsg = "Sorry, can not find this file:" + fullPath;
			return new ResponseEntity<byte[]>(errMsg.getBytes("UTF8"),head,HttpStatus.CREATED);
		}
	}

	@RequestMapping(value="/download2",method=RequestMethod.GET)
	public ResponseEntity<byte[]>  getFile2() throws IOException {
		String sftpKeyPath = props.get("sftp_key_path");
		String fullPath = sftpKeyPath +"known_hosts";
		File f = new File(fullPath);
		HttpHeaders head = new HttpHeaders();
		head.setContentDispositionFormData("attachments", "known_hosts");
		head.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		if (f.exists()){
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(f),head,HttpStatus.CREATED);
		}else {
			String errMsg = "Sorry, can not find this file:" + fullPath;
			return new ResponseEntity<byte[]>(errMsg.getBytes("UTF8"),head,HttpStatus.CREATED);
		}
	}

	@RequestMapping(value="/listAll")
	public String listAllFiles(Model model) throws IOException{
		// 1. Temp folder files
		String tempFileStr = "<br><p>List All Temp Files</p>";
		String tempFolderStr=System.getProperty("java.io.tmpdir");
		File tempFolder = new File(tempFolderStr);
		if (tempFolder.isDirectory()){
			File[] tempFolderFiles = tempFolder.listFiles();
			for (File tempFolderFile:tempFolderFiles) {
				tempFileStr += "<a target='_blank' href='/download/"+tempFolderFile.getName()+"'>" + tempFolderFile.getName() + "</a>" +"<br>";
			}
		}
		model.addAttribute("tempFolderFiles", tempFileStr);

		// 2. Ssh folder files
		String tempKeyFolderStr = "<br><p>List All SSH key Files</p>";
		String sftpKeyPath = props.get("sftp_key_path");
		File keyFolder = new File(sftpKeyPath);
		if (keyFolder.isDirectory()){
			File[] keyFiles = keyFolder.listFiles();
			InputStream in = null;
			StringBuffer sb = new StringBuffer();
			for (File keyFolderFile:keyFiles) {
				byte[] tempbytes = new byte[100];
				int byteread = 0;
				in = new FileInputStream(keyFolderFile);
				//ReadFromFile.showAvailableBytes(in);
				// 读入多个字节到字节数组中，byteread为一次读入的字节数
				while ((byteread = in.read(tempbytes)) != -1) {
					System.out.write(tempbytes, 0, byteread);
					sb.append(new String(tempbytes, "UTF8"));
				}

				/*
				BufferedReader br = new BufferedReader(new FileReader(keyFolderFile));
				String line = null;
				while((line= br.readLine()) != null) {
					sb.append(line);
				}
				*/
				tempKeyFolderStr += "<a target='_blank' href='/download?file="+keyFolderFile.getName()+"'>" + keyFolderFile.getName() + "</a>:"+ sb.toString() +"<br>";
			}
		}
		model.addAttribute("keyFolderFiles",tempKeyFolderStr);

		return "AllFiles";
	}

	@RequestMapping(value="/deleteAll")
	public String deleteAllFiles() throws IOException{
		String tempFolderStr=System.getProperty("java.io.tmpdir");
		File files = new File(tempFolderStr);
		FileUtils.cleanDirectory(files);
		return "Success";
	}

	@RequestMapping(value="/Test",method = RequestMethod.GET)
	public String testHttpsPostFile(Model model){
		String message = "";
		message += formService.testSftpFile(); // formService.postFileToServer("temp file string content for testing......");
		message += formService.testSftpHost();
		model.addAttribute("message", message);
		return "Test";
	}

	@RequestMapping(value = "/Epay",method = RequestMethod.GET)
	public String epayUserUrl(){
		String userUrl = PropertiesReader.getPropertie("Epay");
		return "redirect:"+userUrl;
	}

	void initForm(Form form){
		if(form.getInsideUS().trim().equals("No")){
			form.setState("");
			form.setMailingAddress("");
			form.setMailingAddress1("");
			form.setMailingAddress2("");
			form.setZipCode("");
			form.setZipCodePlus("");
			form.setCity("");
		}else{
			form.setCurrentMaillingAddress("");
		}
	}

	@RequestMapping(value="/SuccessSubmit",method=RequestMethod.GET)
	public String successSubmit(){
		return "SuccessSubmit";
	}

	@RequestMapping(value="/Error",method=RequestMethod.GET)
	public String submitError(){
		return "Error";
	}

	public boolean processFromCtrlFun(HttpServletRequest request,Form form, Model model){
		String logContent = "";
		this.initForm(form);
		String firstAndLastName= form.getFirstName()+form.getLastName();
		/*
		 *If UST(C) is selected the system shall treat it as two applications.
		 *The system shall generate in the backend two applications, one application shall be for (a) and the other application shall be for (b).
		 *The data in both applications shall be exactly the same except one will have UST option A and the other will have UST option B.
		 */
		//-----------------init END---------//
		try {
			String formFileContent = formService.createFile(form);
			String licenseType = formService.getLicenseType(form);
			String folderName =  formService.saveForm(formFileContent,licenseType,firstAndLastName,form.getPrefixOfName(),form);

			logContent += folderName + "\r\n";

			String licenseTypeSe = licenseType;
			if (folderName!=null&&folderName.length()>0){
				licenseTypeSe = folderName;
			}

			List<String> attachmentFileNames = null;

			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			if(multipartResolver.isMultipart(request)){
				MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
				attachmentFileNames = formService.saveAttachement(multipartHttpServletRequest,folderName,licenseTypeSe,form,licenseType);
			}

			logContent += "licenseType:"+licenseType+"\t Path:  "+folderName+"\tApplicant:  "+form.getFirstName()+" "+form.getMiddleName()+" "+form.getLastName();
			formService.log(logContent,licenseType,folderName,form);

			if(form.getWorkEmail()!=null&&!form.getWorkEmail().equals("")){
				formService.sendEmail(form.getWorkEmail(),form.getFirstName(),licenseTypeSe);
			}
			else if(form.getPersonalEmail()!=null&&!form.getPersonalEmail().equals("")){
				formService.sendEmail(form.getPersonalEmail(),form.getFirstName(),licenseTypeSe);
			}
			formService.sendEmailToAdmin(attachmentFileNames,form,folderName);
			if(!form.getVoucherNumber().equals("")&&form.getVoucherNumber()!=null){
				String updateStatus = formService.updateVourcherNumberStatus(formService.VOUCHER_NUMBER, "APPLIED");
				if (updateStatus.equalsIgnoreCase("SUCCESS")){
					return true;
				}else {
					model.addAttribute("errmsg",updateStatus);
					return false;
				}
			}
			return true;
		} catch (IOException | MessagingException | URISyntaxException | ErrorResponse e) {
			e.printStackTrace();
			model.addAttribute("errmsg", e.getMessage());
		}
		return false;
	}

	@RequestMapping(value="/submitForm",method=RequestMethod.POST)
	public String processFromCtrl(HttpServletRequest request,HttpServletResponse response,Form form, Model model){

		try {
			Cookie cookie = new Cookie("jsessionid", "2jcligmgi6fh");
			cookie.setMaxAge(Integer.MAX_VALUE);
			response.addCookie(cookie);

			String hostUrl = PropertiesReader.getPropertie("host_name");
			String successUrl = hostUrl + "SuccessSubmit";
			//String errorUrl = hostUrl + "Error";

			if (formService.getLicenseType(form).equals("UST(AB)")) {
				//UST A
				TypeOfLicencsApplication typeOfLicenseApp = new TypeOfLicencsApplication();
				typeOfLicenseApp.setUST("A");
				form.setUSTAFiles("true");
				form.setTypeOfLicenseApp(typeOfLicenseApp);
				boolean bUSTA = this.processFromCtrlFun(request, form, model);
				//UST B
				typeOfLicenseApp.setUST("B");
				form.setTypeOfLicenseApp(typeOfLicenseApp);
				form.setUSTBFiles("true");
				boolean bUSTB = this.processFromCtrlFun(request, form, model);
				//return "SuccessSubmit";
				//return "redirect:/SuccessSubmit";
				if (bUSTA && bUSTB) {
					//return new ModelAndView("redirect:" + successUrl);
					response.sendRedirect(successUrl);
					return null;
				}
				//return new ModelAndView("redirect:"+errorUrl);
				return "ERROR";
			}

			if (this.processFromCtrlFun(request, form, model)) {
				//return new ModelAndView("redirect:"+successUrl);
				response.sendRedirect(successUrl);
				return null;
			}
			//return new ModelAndView("redirect:"+errorUrl);
			//response.sendRedirect(errorUrl);
			return "ERROR";
		}catch (IOException ex){
			ex.printStackTrace();
			model.addAttribute("errmsg", ex.getMessage());
		}
		return "ERROR";
	}

	/**
	 *
	 * @param vourcherNumber
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/vourcherCheck")
	public String ePayCtrl(@RequestParam(required=true) String vourcherNumber,@RequestParam(required=true)String amount,HttpServletRequest request,HttpServletResponse response, Model model){
		String errMessage = "";
		try {
			String result =  formService.vourcherNumberChecker(vourcherNumber,amount);
			return result ;
		} catch (RemoteException e) {
			e.printStackTrace();
			errMessage += e.getMessage();
		} catch (ErrorResponse e) {
			e.printStackTrace();
			errMessage += e.getMessage();
		}

		model.addAttribute("errmsg", errMessage);
		return "ERROR";
	}

	/**
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping("/confirm")
	public String confirm(@RequestParam(required=true)String comfirmcode,@RequestParam(required=true)String email,Model model){
		/**
		 * Authentication(send a  number to email)
		 */
		if(email!=null&&confirmCodeMap!=null&&confirmCodeMap.containsKey(email)){
			if(confirmCodeMap.get(email).equals(comfirmcode.trim())){
				/**
				 * getPropertie 
				 */
				Map<String,String> tmpMap = PropertiesReader.getPropertie();

				Map<String,String> emails = new HashMap<String,String>();
				emails.put("email_list", tmpMap.get("email_list"));
				emails.put("email_host", tmpMap.get("email_host"));
				emails.put("email_port", tmpMap.get("email_port"));
				emails.put("email_username", tmpMap.get("email_username"));
				emails.put("email_password", tmpMap.get("email_password"));
				model.addAttribute("emails", emails);
				Map<String,String> files = new HashMap<String,String>();
				files.put("sftp_path", tmpMap.get("sftp_path"));
				files.put("sftp_host", tmpMap.get("sftp_host"));
				files.put("sftp_port", tmpMap.get("sftp_port"));
				files.put("sftp_username", tmpMap.get("sftp_username"));
				files.put("sftp_password", tmpMap.get("sftp_password"));
				files.put("sftp_private_key_path", tmpMap.get("sftp_private_key_path"));
				files.put("sftp_known_hosts_key_path", tmpMap.get("sftp_known_hosts_key_path"));
				files.put("sftp_key_path", tmpMap.get("sftp_key_path"));
				//files.put("form_path", tmpMap.get("form_path"));
				//files.put("log_path", tmpMap.get("log_path"));
				files.put("logMaxSize", tmpMap.get("logMaxSize"));
				files.put("Upload_Max_Size", tmpMap.get("Upload_Max_Size"));
				files.put("Upload_File_Type", tmpMap.get("Upload_File_Type"));
				files.put("Epay", tmpMap.get("Epay"));
				model.addAttribute("files", files);
				Map<String,String> license = new HashMap<String,String>();
				license.put("BAT", tmpMap.get("BAT"));
				license.put("CSI", tmpMap.get("CSI"));
				license.put("IRR", tmpMap.get("IRR"));
				license.put("CAS", tmpMap.get("CAS"));
				license.put("PPM", tmpMap.get("PPM"));
				license.put("STT", tmpMap.get("STT"));			
				license.put("OIR", tmpMap.get("OIR"));
				license.put("AMP", tmpMap.get("AMP"));
				license.put("SLC", tmpMap.get("SLC"));
				license.put("SLI", tmpMap.get("SLI"));
				license.put("WQC", tmpMap.get("WQC"));
				license.put("WSC", tmpMap.get("WSC"));
				license.put("ROC", tmpMap.get("ROC"));
				model.addAttribute("license", license);

				Map<String,String> explanations = new HashMap<String,String>();
				Map<String,String> licenseCodes =  GlobalConstant.getLicenseCodes();
				Set<String> keySetLicenseCodes = licenseCodes.keySet();
				for(String key:keySetLicenseCodes){
					explanations.put(key, licenseCodes.get(key));
				}
				model.addAttribute("explanations", explanations);

				return "config";
			}
		}
		model.addAttribute("message", "Not a Valid Confirm Code,Please try again.");
		return "Authentication";
	}


	@RequestMapping("/configSftpPathWithAuthentication")
	public String configAuthentication(){
		//this.getFormService().testSmbFile();
		return "Authentication";
	}

	@RequestMapping("/configEmail")
	public String configAuthenticationSendEmail(@RequestParam(required=true)String email,Model model) throws MessagingException, IOException, URISyntaxException{
		String message = null;
		String emails = "Zon.Yao@ambonare.com Yan.Liu@ambonare.com";
		String[] adminEmail= emails.split(" ");//props.get("email_list")
		for(String s:adminEmail){
			if(email!=null&&email.equals(s)){
				//send email
				Random random = new Random();
				int code = random.nextInt(99999);
				String content ="Confirm Code:  "+code;
				formService.sendEmail(email,content, "Confirm");
				model.addAttribute("email_address", email);
				confirmCodeMap = new HashMap<String,String>();
				confirmCodeMap.put(email, Integer.toString(code));
				return "Confirm";
			}
		}
		//Not valid email address
		message = "Not a valid email address(Need administrator's email)";
		model.addAttribute("message", message);
		return "Authentication";
	}

	@SuppressWarnings({"rawtypes" })
	@RequestMapping("/configSubmit")
	public String configSubmit(HttpServletRequest request){
		Map p= request.getParameterMap();
		PropertiesReader.setPropertie(p);
		props = PropertiesReader.getPropertie();
		return "Success";
	}


	/**
	 * get the fee according to license type
	 * @param key
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@ResponseBody
	@RequestMapping("/prams")
	public String getAllTypesPaymentAmount(@RequestParam(required=true,defaultValue="BPAT") String key,HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException{
		return props.get(key);
	}

	
	public FormService getFormService() {
		return formService;
	}

	public void setFormService(FormService formService) {
		this.formService = formService;
	}
}
