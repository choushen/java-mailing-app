/*
 *            COMP2221 Networks
 *              ReceivingMail Class
 *          Author: Jacob McKenzie
 */

public class ReceivingMail {
  public static void main(String args[]) throws Exception {

    // User instructions
    System.out.println("*****************************************");
    System.out.println("**            INSTRUCTIONS             **");
    System.out.println("*****************************************");

    System.out.println("Enter your Gmail account details when prompted.\n");

    // Calls the function to create our new message
    ReceivingProperties gmailAccount = new ReceivingProperties();
    gmailAccount.displayInbox();

  } // Main end
} // Class end
