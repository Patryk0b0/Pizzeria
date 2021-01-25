package pl.util;

import java.util.Properties;

import javax.mail.Authenticator;
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

public class Mail {

	public void send(String msgString, String from) throws AddressException, MessagingException {
	      String to = "patryk@wp.pl";

	      String host = "smtp.wp.pl";
	      String port = "port";
	      String user = "user";
	      String pass = "pass";

	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);
	      properties.setProperty("mail.smtp.port", port);

	      // Get the default Session object.

	      Session session = Session.getInstance(properties, new Authenticator() {
	    	    @Override
	    	    protected PasswordAuthentication getPasswordAuthentication() {
	    	        return new PasswordAuthentication(user, pass);
	    	    }
	    	});

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("Nowe zamówienie");

	         // Now set the actual message
	         message.setText(msgString);

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
}
