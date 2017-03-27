package com.ambonare.springmail;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.mail.MessagingException;

import org.apache.axis2.AxisFault;

import com.ambonare.TCEQForm.model.Form;
import com.ambonare.TCEQForm.service.FormService;

public class SendToAdminTest {

	public static void main(String[] args) throws MessagingException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
        
			FormService s = new FormService();
	        s.sendEmail("963214153@qq.com", "yang", "test");
			
		
	
          
	}

}
