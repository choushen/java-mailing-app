 # SendingMail and ReceivingMail Applications


**Disclaimer**

I wrote this a long time ago so for it to work you have to do the following:
Go to your Google Account Security page.
Under "Less secure app access", click "Turn on access" and toggle the switch to turn it on.

---

I wanted to push this code up while explaining SMTP, which served as an example.

---
## Instructions

Compile the sender with the following commands:
``` sh
javac -cp ../lib/javax.mail.jar:../lib/jakarta.activation-1.2.1.jar SendingMail.java SendingProperties.java Account.java Email.java

java -cp .:../lib/javax.mail.jar:../lib/jakarta.activation-1.2.1.jar SendingMail
```

Compile the receiver with the following commands:
``` sh
javac -cp ../lib/javax.mail.jar:../lib/jakarta.activation-1.2.1.jar ReceivingMail.java ReceivingProperties.java Account.java

java -cp .:../lib/javax.mail.jar:../lib/jakarta.activation-1.2.1.jar ReceivingMail

```

## Description
For my **SendingMail** application, I used the Gmail SMTP server, making use of SSL to ensure the communication between the two applications had the necessary privacy and that the integrity of the data was kept intact.

For my **ReceivingMail** application, I used the Gmail SMTP server which made use of SSL, ensuring that the communication between my application and Google's mailing application had necessary privacy and that data integrity was provided between the two. I also used the IMAP (Internet Message Access Protocol) to retrieve the messages from the client's inbox via the server.

For both applications, I used port 465 as this port is intended for email client to email server communication and makes use of SSL encryption.

Two Java applications connect to and use an external Gmail account by making use of the JavaMail API and relevant email protocols. The application handles account passwords appropriately by taking user input via the `Console` class and making use of the `readPassword()` function. Divided into modules, the design of the application is object-oriented, encapsulating information appropriately, leaving both main functions looking tidy.

### ReceivingMail Application
This application connects to the Gmail server and allows the user to read their inbox, displaying data in a suitable form.

### SendingMail Application
This application connects to the Gmail server and allows users to compose and send emails to a given email address.

### References
I used materials mostly from docs.oracle.com and Tutorial Point. Tutorial Point was very informative and contained many examples. The section on JavaMail from the java.net site was very helpful as it provided very concise information regarding classes. This helped me find the classes I needed to build both parts of my applications as well as how to properly use them. Below you can find the links to the websites used:
- [Oracle Documentation](http://docs.oracle.com)
- [JavaMail Project on java.net](https://java.net/projects/javamail/pages/Home)
- [Tutorials Point JavaMail API](http://www.tutorialspoint.com/javamail_api)
