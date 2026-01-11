package com.gul.test;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gul.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
//@ContextConfiguration(locations = "classpath:aprpcontext.xml")
@WebAppConfiguration
public class TestMail2 {

	@Autowired
	JavaMailSender mailSender;

	@Test
	public void sendMail() {
//		try {
//			Message message = mailSender.createMimeMessage();
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//			message.setSubject("Testing Subject");
//			message.setContent("<h1>Assalumo Alaykum Shaquib Nawaz</h1></b>From Gulrez Farooqui", "text/html");
//			mailSender.send(message);
//			System.out.println("Sent message successfully....");
//
//		} catch (MessagingException e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//		System.out.println("send");

//		new 
		MimeMessage message = mailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom("GulrezFarooqui");
			helper.setTo("gulfarooqui09@gmail.com");
			helper.setSubject("Subject");
//			helper.setText(String.format(simpleMailMessage.getText(), dear, content));
			String htmlText = "<div style='background:#00FA9A;text-align:center;"
					+ "font-size:12pt;font-weight:bold;color:#800000;padding:10px;'>"
					+ "That feeling when......<br /><br />"
					+ "You miss your spectacles while looking for your spectacles....<br /><br />"
					+ "The person whom you secretly dislike, helps you......<br /><br />"
					+ "The person whom you have crush on seems happy all the time....<br /><br />"
					+ "the beggar recognizes you and stops asking for penny from you since you have never given....<br /><br />"
					+ "</div>";

			helper.setText(htmlText, true);
			FileSystemResource file = new FileSystemResource("C:/Users/gulfa/Downloads/6872288-night-landscape-wallpaper.jpg");
			helper.addAttachment(file.getFilename(), file);

		} catch (MessagingException e) {
			throw new MailParseException(e);
		}
		mailSender.send(message);
		System.out.println("Mail Sent");
	}
}
