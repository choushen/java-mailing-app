/*
 *             COMP2221 Networks
 *         ReceivingProperties Class
 *          Author: Jacob McKenzie
 */

 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.io.Console;

 import java.util.Properties;
 import java.util.Properties;

 import javax.mail.*;
 import javax.mail.internet.*;
 import javax.mail.Session;
 import javax.activation.DataHandler;

class ReceivingProperties {

  public void displayInbox() {

    // Takes username and password input from the user
    Account signIn = new Account();
    String host = "smtp.gmail.com";

    // Prevents MessagingException
    try {

      // Set of properties for sending external messages via smtp.gmail.com
      Properties propInfo = new Properties();
      try {
        propInfo.load(new FileInputStream(new File("settings.properties"))); // Dynamic properties via FileInputStream
      } catch (FileNotFoundException e1) {
        e1.printStackTrace();
      } catch (IOException e1) {
        e1.printStackTrace();
      }

      // Creates a mail session
      Session session = Session.getInstance(propInfo,
      new javax.mail.Authenticator() {
       protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(signIn.getEmailAddress(), signIn.getPassword());
       }
      });

      // Creates message store model
      Store store = session.getStore("imaps");
      store.connect(host, signIn.getEmailAddress(), signIn.getPassword());
      Folder inbox = store.getFolder("inbox");
      inbox.open(Folder.READ_ONLY);

      int messageCount = inbox.getMessageCount();
      System.out.println("===============================");
      System.out.println("| Inbox Message Count: " + messageCount);
      System.out.println("===============================\n");

      // get the list of inbox messages
      Message[] messages = inbox.getMessages();

      if(messages.length == 0) System.out.println("Your inbox is empty!.");

      // Iterating through messages
      for (int i = 0; i < messages.length; i++) {
        // Displays text/plain messages with an elfi to fitler and display text/html
        if(messages[i].isMimeType("text/plain")){
            System.out.println( "====================================================" );
            System.out.println( "Sender: " +  messages[i].getFrom()[0].toString() );
            System.out.println( "*Subject*" +  messages[i].getSubject().toString() );
            System.out.println( "*Message*" + messages[i].getContent().toString() );
            System.out.println( "====================================================" );
          } else if(messages[i].isMimeType("multipart/*")) {
            String result = "";
            MimeMultipart mimeMultipart = (MimeMultipart)messages[i].getContent();
            int count = mimeMultipart.getCount();
            for(int j = 0; j < count; j++) {
              BodyPart messageBody = mimeMultipart.getBodyPart(j);
              if(messageBody.isMimeType("text/plain")) {
                result = result + "\n" + messageBody.getContent();
                break;
              } else if(messageBody.isMimeType("text/html")) {
                String html = (String) messageBody.getContent();
                result = result + "\n" + html;
              } // nested elif end
            } // nested for end
            int msgIndex = i+1;
            System.out.println("Message Number: " + msgIndex);
            System.out.println("====================================================");
            System.out.println("Sender: " +  messages[i].getFrom()[0].toString());
            System.out.println("*Subject*" +  messages[i].getSubject().toString());
            System.out.println("*Message HTML*" + result);
            System.out.println("====================================================");
          } // elif end
        } // for end
      inbox.close(true);
      store.close();
    }  catch(MessagingException msg) {
      System.err.println("Messaging Exception!");
      msg.printStackTrace();
    } catch(IOException e) {
      e.printStackTrace();
    }
  } // displayInbox end
} // ReceivingProperties end
