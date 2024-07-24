/*
 *              Email Class
 *          Author: Jacob McKenzie
 */

import java.io.Console;

class Email {

  // Object for controlling user input
  Console console = System.console();

  // Private variables
  // Takes input and uses as the recipient's email address
  private String recipient =  console.readLine("[%s] ", "Recipient");
  // Takes input and sets message subject
  private String emailSubject =  console.readLine("[%s] ", "Subject");
  // Takes input for user message
  private String messageBody = console.readLine("[%s]", "Message");

/*
 * Email class get methods
 */

 public String getRecipient() {
   return recipient;
 } // setEmailAddress end

 public String getEmailSubject() {
   return emailSubject;
 } // setPassword

 public String getMessageBody() {
  return messageBody;
 } // setPassword end

} // Account end
