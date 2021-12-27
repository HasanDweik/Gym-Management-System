package application;



import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;

import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class JavaMailUtil {

	public static void sendMail(String recepient,String filedir, String valid_from, String valid_till) throws Exception {
		System.out.println("Preparing to send email");
		Properties properties = new Properties();
		properties.put("mail.smtp.auth",true);
		properties.put("mail.smtp.starttls.enable",true);
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		
		String myAccountEmail = "the.gladiator.h7d.gym@gmail.com";
		String password = "GladiatorH7D";
		
		Session session = Session.getInstance(properties, new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
			
		});
		
		Message message = prepareMessage(session,myAccountEmail,recepient,filedir,valid_from,valid_till);
			

			Transport.send(message);
			System.out.println("Email sent successfully");

	}
	
	public static Message prepareMessage(Session session,String myAccountEmail,String recepient,String filedir,String valid_from, String valid_till) {
		try {
			Message message =new MimeMessage(session);		
	
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("The Gladiators Gym Entrance Key");

			
			Multipart emailContent = new MimeMultipart();
			
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Use the following png image to enter the gym. \n"
					+ "Your membership is valid from " + valid_from + " till " +valid_till);
			
			MimeBodyPart imageBodyPart = new MimeBodyPart();
			imageBodyPart.attachFile(filedir);
			
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(imageBodyPart);
			
			message.setContent(emailContent);
			
			return message;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE,null,ex);
		}
		return null;
	}
	
}
