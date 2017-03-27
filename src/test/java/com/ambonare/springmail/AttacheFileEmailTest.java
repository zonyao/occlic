package com.ambonare.springmail;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class AttacheFileEmailTest {

	public static void main(String[] args) throws MessagingException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
      JavaMailSenderImpl simpleSender = new JavaMailSenderImpl();
      simpleSender.setHost("smtp.163.com");
//      SimpleMailMessage message = new SimpleMailMessage();
//      message.setTo("963214153@qq.com");
//      message.setFrom("yanglin262510@163.com");
//      message.setSubject("Simple mail test!");
//      message.setText("Yang, \n This is a test message");
      
      MimeMessage message =    simpleSender.createMimeMessage();
      MimeMessageHelper help = new MimeMessageHelper(message,true);
      help.setTo("963214153@qq.com");
      help.setFrom("yanglin262510@163.com");
      help.setSubject("HTML Message");
      help.setText("<html><head></head><body><h1>Yang <br/> PDF File see attached</h1>"
      		+ "<img src=\"cid:aaa\"></img>"//Image DOM cid:resourceId
      		+ "</body></html>",true);
      //add img to html..
      FileSystemResource resource = new FileSystemResource("/home/lin/Pictures/Screenshot_from_2016-03-04_15:26:45.png");
      help.addInline("aaa", resource);
      //add attach file there
      FileSystemResource attache = new FileSystemResource("/home/lin/Scantron_Form.pdf");
      help.addAttachment("Form PDF file", attache);
      
      simpleSender.setUsername("yanglin262510@163.com");
      simpleSender.setPassword("ly96244");
      
      Properties pro = new Properties();
      pro.put("mail.smtp.auth", "true");
      pro.put("mail.smtp.timeout", 25000);
      
      simpleSender.setJavaMailProperties(pro);
      simpleSender.send(message);
      
      System.out.println("mail send success");
	
	
	}

}
