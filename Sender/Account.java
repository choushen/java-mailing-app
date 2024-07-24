/*
 *              Account Class
 *          Author: Jacob McKenzie
 */

import java.io.Console;

class Account {

  Console console = System.console();

  // Takes the email input from the user
  private String emailAddress = console.readLine("[%s] ", "Gmail");
  // Takes password input from the user
  private char[] password = console.readPassword("[%s] ", "Password");
  // Converts character array to string so it can be passed
  String pass = new String(password);

/*
 * Account class get methods
 */

  public String getEmailAddress() {
    return emailAddress;
  } // getEmailAddress end

  public String getPassword() {
    return pass;
  } // getPassword end

} // Account end
