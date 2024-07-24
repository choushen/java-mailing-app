/*
 *              SendingMail Class
 *          Author: Jacob McKenzie
 */

public class SendingMail {
  public static void main(String[] args) {

    // User instructions
    System.out.println("*****************************************");
    System.out.println("**            INSTRUCTIONS             **");
    System.out.println("*****************************************");

    System.out.println("Step 1: Sign into your Gmail account");
    System.out.println("Step 2: Enter the recipient email address");
    System.out.println("Step 3: Enter your email subject and message body\n");

    // Calls the function to create our new message
    SendingProperties newMessage = new SendingProperties();
    newMessage.messageProperties();

  } // main end
} // SendingMail end
