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

public class EmailDispatcher {

    Properties prop = System.getProperties();

    public void dispatchEmail(String receiver_name, String receiver_email, String id, String pass) throws MessagingException {

        System.out.println("Email MEthod Started");
        String message = " Hello welome " + receiver_name + " to libsys System we send you this details to verify your credintials"
                + ". This help us to maintain privacy of our users. The id and password is given below you can login in with this"
                + "detail on libsys.com. After login you need to change your password and need to feel you Full Details Properly"
                + "\n User Id " + id + " \n Password " + pass;

        String host = "smtp.gmail.com";
        String SSL_Factory = "javax.net.ssl.SSLSocketFactory";
        boolean sessionDebug = true;
        System.out.println("Putting Property");
        prop.put("mail.smtp.host", host);

        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.connectiontimeout", "10000");
        prop.put("mail.user", "rakeshsl546@gmail.com");
        prop.put("mail.password", "M@darchod9146");

        prop.put("mail.smtp.socketFactory.class", SSL_Factory);
        System.out.println("Starting SEssion");
        javax.mail.Session mailSession = javax.mail.Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("rakeshsl546@gmail.com", "R@kesh9146");
            }

        });

        try {
            mailSession.setDebug(sessionDebug);
            System.out.println("Creating Messaged");
            Message message1 = new MimeMessage(mailSession);
            System.out.println("Attaching Addresses");
            Address ad = new InternetAddress("rakeshsl546@gmail.com");
            message1.setFrom(ad);
            message1.setSubject("Welcome To libsys");
            message1.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver_email));
            message1.setText(message);
//            message1.setContent(message, "text/html");

            Transport.send(message1, message1.getAllRecipients());

            System.out.println("Email Successfully Sent");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
