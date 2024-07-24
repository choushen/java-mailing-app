/*
 *          SendingProperties Class
 *          Author: Jacob McKenzie
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingProperties {

    public void messageProperties() {

          // Takes username and password input from the user
          Account signIn = new Account();

          // Creates the message object
          Email newMessage = new Email();

          // Set of properties for sending external messages via smtp.gmail.com
          Properties propInfo = new Properties();
          try {
            propInfo.load(new FileInputStream(new File("settings.properties"))); // Dynamic properties via FileInputStream
          } catch (FileNotFoundException e1) {
            e1.printStackTrace();
          } catch (IOException e1) {
            e1.printStackTrace();
          }
          // Creates mail session by creating session object
          Session session = Session.getInstance(propInfo,
          new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(signIn.getEmailAddress(), signIn.getPassword());
           }
          });
          try {
           // Create a default MimeMessage object.
           Message message = new MimeMessage(session);
           // Set From: header field of the header.
           message.setFrom(new InternetAddress(signIn.getEmailAddress()));
           // Set To: header field of the header.
           message.setRecipients(Message.RecipientType.TO,
           InternetAddress.parse(newMessage.getRecipient()));
           // Set Subject: header field
           message.setSubject(newMessage.getEmailSubject());
           // Now set the actual message
           message.setText(newMessage.getMessageBody());
           // Send message
           Transport.send(message);
           // Confirms the message has been sent
           System.out.println("Your message has been sent.");
          } catch (MessagingException e) {
              throw new RuntimeException(e);
          } // catch
    } // messageProperties end
} // SendingProperties end
