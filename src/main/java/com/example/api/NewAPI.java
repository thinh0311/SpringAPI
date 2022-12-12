package com.example.api;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class NewAPI {

	@GetMapping("/test")

	public String testAPI() {

		return "PRODUCTION V0.2";

	}

	@GetMapping("/Email/SendOTP/{email}")
	public int sendOTP(@PathVariable("email") String email) throws AddressException, MessagingException, IOException {
		int OTP = (int) Math.floor(((Math.random() * 8999999) + 1000000));
		String text = "Ma xac thuc cua ban la: " + OTP;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("drinkstore0311@gmail.com", "kozychosgczhywgg");
			}
		});

		Message msgMessage = new MimeMessage(session);
		msgMessage.setFrom(new InternetAddress("drinkstore0311@gmail.com", false));
		msgMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.toString()));
		msgMessage.setSubject("Xác thực OTP");
		msgMessage.setContent(text.toString(), "text/html");
		msgMessage.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(text.toString(), "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		msgMessage.setContent(multipart);

		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.gmail.com", "drinkstore0311@gmail.com", "kozychosgczhywgg");
		transport.sendMessage(msgMessage, msgMessage.getAllRecipients());
		transport.close();
		return OTP;
	}

	@GetMapping("/Email/SendMail/{email}/{body}")
	public String sendMail(@PathVariable("email") String email, @PathVariable("body") String body) throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("drinkstore0311@gmail.com", "kozychosgczhywgg");
			}
		});

		Message msgMessage = new MimeMessage(session);
		msgMessage.setFrom(new InternetAddress(email, false));
		msgMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse("drinkstore0311@gmail.com"));
		msgMessage.setSubject("Phản hồi của khách hàng");
		msgMessage.setContent(body, "text/html");
		msgMessage.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(body, "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		msgMessage.setContent(multipart);

		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.gmail.com", "drinkstore0311@gmail.com", "kozychosgczhywgg");
		transport.sendMessage(msgMessage, msgMessage.getAllRecipients());
		transport.close();
		return "OK";
	}
}