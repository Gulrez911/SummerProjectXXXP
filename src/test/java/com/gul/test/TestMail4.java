package com.gul.test;

import java.io.File;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gul.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
//@ContextConfiguration(locations = "classpath:aprpcontext.xml")
@WebAppConfiguration
public class TestMail4 {

	@Autowired
	JavaMailSender mailSender;

	@Test
	public void sendMail() throws MessagingException {
 		MimeMessage mimeMessage = mailSender.createMimeMessage();
		FileSystemResource file = new FileSystemResource(new File(
				"C:/Users/gulfa/Downloads/apple-20clip-20art-nicubunu_Apple_Clipart_Free.png"));
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.addTo("gulfarooqui09@gmail.com");
		helper.setFrom("xyz@gmail.com");
		helper.setText("Hi");
		helper.addAttachment(file.getFilename(), file);
		mailSender.send(mimeMessage);

		System.out.println("Mail sent successfully!!!");
		System.out.println("Mail Sent");
	}
}
