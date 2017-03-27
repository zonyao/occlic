package com.ambonare.springmail;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
/*
 * David yang
 * 2016-03-03 
 */
public class SimpleMailSendTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      JavaMailSenderImpl simpleSender = new JavaMailSenderImpl();
      simpleSender.setHost("smtp.163.com");
      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo("963214153@qq.com");
      message.setFrom("yanglin262510@163.com");
      message.setSubject("Simple mail test!");
      message.setText("Yang, \n This is a test message");
      
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
