package pl.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import pl.model.History;
import pl.model.HistoryItem;

public class Mail {

	public static void send(String msgString, String from) {
	      String to = "to";

	      String host = "server";
	      String port = "25";
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
	      
			System.out.println(msgString);
	}

	public static String mailFormat(History history) {
		String items = "";
		
		for (HistoryItem item : history.getItems()) {
			items = items + item.getItem() + "\n\r";
		}
		String mailText = String.format("Zamówienie od %s %s.\n\rData zamówienia: %02d:%02d:%02d.\n\rZamówiono: \n\r%s", history.getName(), history.getSurname(), history.getDate().getYear(), history.getDate().getMonthValue(), history.getDate().getDayOfMonth(), items);
		
		return mailText;
	}
}
