package com.example.easynotes.dao;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Repository;
@Repository
public class EmailNotificationDaoImpl implements EmailNotificationDao {

	@Override
	public void emailRequestDetails(com.example.easynotes.model.EmailRequestDetails emailReq) {
		// TODO Auto-generated method stub
		final String fromEmail = "arnab.s1993@gmail.com"; 
		final String password = "manjusarkar@1"; 
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		sendEmail(session, emailReq.getToEmail(),emailReq.getMessageTitle(), emailReq.getMessageBody());
		
	}

	public static void sendEmail(Session session, String toEmail, String subject, String body){
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("arnab.s1993@gmail.com", "ABC Bank"));

	      msg.setReplyTo(InternetAddress.parse("arnab.s1993@gmail.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
    	  Transport.send(msg);  

	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}
