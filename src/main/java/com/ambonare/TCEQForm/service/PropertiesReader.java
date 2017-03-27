package com.ambonare.TCEQForm.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.cxf.common.i18n.Exception;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.net.InetAddress;

public class PropertiesReader {
	
	private static final String CONF_NAME="TCEQForm.properties";
	private static final String WINDOWS_CONF_NAME="WINDOWSTCEQForm.properties";
	private static final String WINDOWS_CONF_NAME_DEV="WINDOWSTCEQFormDev.properties";
	private static final String WINDOWS_CONF_NAME_TST="WINDOWSTCEQFormTST.properties";
	private static final String WINDOWS_CONF_NAME_PRO="WINDOWSTCEQFormPro.properties";
	public PropertiesReader pr;

	public static String getPropertyFile(){
		String propertyFile = CONF_NAME;
		if (isWindows()) {
			propertyFile = WINDOWS_CONF_NAME;
			try {
				InetAddress ip = InetAddress.getLocalHost();
				String hostName = ip.getHostName();
				String hostNameUpper = hostName.toUpperCase();
				if (hostNameUpper.contains("MSJBD")){
					propertyFile = WINDOWS_CONF_NAME_DEV;
				}else if (hostNameUpper.contains("MSJBT")){
					propertyFile = WINDOWS_CONF_NAME_TST;
				}else{
					propertyFile = WINDOWS_CONF_NAME_PRO;
				}
			}catch (UnknownHostException ex){
				System.out.println(ex.getMessage());
			}
		}
		return propertyFile;
	}

	public static String getPropertie(String key){
		String propertyFile = getPropertyFile();
		Resource resource = new ClassPathResource("/"+propertyFile);
		Properties props = null;
		try {
			props = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = props.getProperty(key);
		return value;
	}
	/**
	 * return all properties with a map
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException 
	 */
	public static Map<String,String> getPropertie(){
		String propertyFile = getPropertyFile();
		Map<String,String> properties=new HashMap<String,String>();
		Resource resource = new ClassPathResource("/"+propertyFile);
		Properties pro=null;
		try {
			pro = PropertiesLoaderUtils.loadProperties(resource);
			Set<String> pros =  pro.stringPropertyNames();
			for(String p:pros){
				properties.put(p, pro.getProperty(p));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return properties;
	}
	/**
	 * update properties with Map<String,String>
	 * @param pros
	 */
	public static void setPropertie(@SuppressWarnings("rawtypes") Map pros){
		String propertyFile = getPropertyFile();
		Resource resource = new ClassPathResource("/"+propertyFile);
		Properties props = null;
		try {
			props = PropertiesLoaderUtils.loadProperties(resource);
			@SuppressWarnings("unchecked")
			Set<String> keys = pros.keySet();
			for(String key:keys){
				String[] value = (String[]) pros.get(key);
				props.setProperty(key,  value[0]);
			}
			FileOutputStream fos = new FileOutputStream(resource.getFile());
			System.out.println(resource.getFile());
			props.store(fos, "update propertie");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 /**
	  * is windows
	  * @return boolean
	  */
	 public static boolean isWindows(){
	  boolean flag = false;
	  if (System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
	   flag = true;
	  }
	  return flag;
	 } 
}
