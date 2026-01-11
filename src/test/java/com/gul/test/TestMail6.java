package com.gul.test;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gul.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class TestMail6 {

	@Autowired
	private JavaMailSender mailSender;

	@Test
	public void home() {
		try {
			sendEmail();
		} catch (Exception ex) {
		}
	}

	public void sendEmail() throws Exception {
		 MimeMessage message = mailSender.createMimeMessage();
	         
		        // Enable the multipart flag!
		        MimeMessageHelper helper = new MimeMessageHelper(message,true);
		         helper.setFrom("gulfarooqui1@gmail.com");
		        helper.setTo("gulfarooqui09@gmail.com");
		        helper.setText("How are you?");
		        helper.setSubject("Hi");
		         
		        ClassPathResource file = new ClassPathResource("cat.jpg");
		        helper.addAttachment("cat.jpg", file);
		         
		        mailSender.send(message);
		System.out.println("Mail Sent Successfully");
	}

}
