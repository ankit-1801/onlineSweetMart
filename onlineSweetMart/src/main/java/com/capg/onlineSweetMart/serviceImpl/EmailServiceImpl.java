package com.capg.onlineSweetMart.serviceImpl;
import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

import com.capg.onlineSweetMart.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public boolean sendMail(String message, String subject, String to) {
		boolean f=false;
		//Variable for gmail
				String host="smtp.gmail.com";
			    String from = "negiankit7053@gmail.com";
				//get the system properties
				Properties properties = System.getProperties();
				System.out.println("PROPERTIES "+properties);
				
				//setting important information to properties object
				
				//host set
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port","465");
				properties.put("mail.smtp.ssl.enable","true");
				properties.put("mail.smtp.auth","true");
				
				//Step 1: to get the session object..
				Session session=Session.getInstance(properties, new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {				
						return new PasswordAuthentication("negiankit7053@gmail.com", "****************");
					}
					
					
					
				});
				
				session.setDebug(true);
				
				//Step 2 : compose the message [text,multi media]
				MimeMessage m = new MimeMessage(session);
				
				try {
				
				//from email
				m.setFrom(from);
				
				//adding recipient to message
				m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				
				//adding subject to message
				m.setSubject(subject);
			
				
				//attachement..
				
				//file path
				String path="C:\\Users\\user\\Desktop\\ca_logo.png";
				
				
				MimeMultipart mimeMultipart = new MimeMultipart();
				//text
				//file
				
				MimeBodyPart textMime = new MimeBodyPart();
				
				MimeBodyPart fileMime = new MimeBodyPart();
				
				try {
					
					textMime.setText(message);
					
//					File file=new File(path);
//					fileMime.attachFile(file);
					
					
					mimeMultipart.addBodyPart(textMime);
//					mimeMultipart.addBodyPart(fileMime);
				
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				
				m.setContent(mimeMultipart);
				
				
				//send 
				
				//Step 3 : send the message using Transport class
				Transport.send(m);
			    f=true;			
				
				}catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("Sent success...................");
				
		return f;
	}

}
