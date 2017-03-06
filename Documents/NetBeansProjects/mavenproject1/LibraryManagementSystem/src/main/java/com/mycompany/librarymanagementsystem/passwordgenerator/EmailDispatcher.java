package com.mycompany.librarymanagementsystem.passwordgenerator;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.hibernate.Session;

public class EmailDispatcher {

    Properties prop = System.getProperties();

    public void dispatchEmail(String receiver_name, String receiver_email, String id, String pass) throws MessagingException {

        String message = " Hello welome " + receiver_name + " to libsys System we send you this details to verify your credintials"
                + ". This help us to maintain privacy of our users. The id and password is given below you can login in with this"
                + "detail on libsys.com. After login you need to change your password and need to feel you Full Details Properly"
                + "\n User Id " + id + " \n Password " + pass;

        String host = "smtp.gmail.com";
        String SSL_Factory = "javax.net.ssl.SSLSocketFactory";
        boolean sessionDebug = true;

        prop.put("mail.host", host);
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.SocketFactory.fallback", "false");
        prop.put("mail.smtp.socketFactory.class", SSL_Factory);

        javax.mail.Session mailSession = javax.mail.Session.getDefaultInstance(prop, null);
        mailSession.setDebug(sessionDebug);

        Message message1 = new MimeMessage(mailSession);

        Address ad = new InternetAddress("rakeshsl546@gmail.com");
        message1.setFrom(ad);
        message1.setSubject("Welcome To libsys");
        message1.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver_email));
        message1.setContent(message, "textt/css");

        Transport transport = mailSession.getTransport("smtp");
        transport.connect(null, "rakeshsl546@gmail.com", "M@darchod9146");

        transport.sendMessage(message1, message1.getAllRecipients());
        System.out.println("Email Successfully Sent");

    }
}
