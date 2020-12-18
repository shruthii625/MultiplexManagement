package com.multiplex.mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class maii {
    public int sendMail(String to) {
        Properties props = new Properties();
        props.put("mail.smtp.host" , "smtp.gmail.com");
        props.put("mail.smtp.user" , "shruthiiiscool@gmail.com");

        //To use TLS
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.password", "sajju2000");
        //To use SSL
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", 
            "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", "465");

       Session session = Session.getDefaultInstance(props,
        	    new Authenticator() {
        	        protected PasswordAuthentication  getPasswordAuthentication() {
        	        return new PasswordAuthentication(
        	                    "shruthiiiscool@gmail.com", "sajju2000");
        	                }
        	    });
        
        String from = "shruthiiiscool@gmail.com";
        String subject = "Testing...";
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, 
                new InternetAddress(to));
            msg.setSubject(subject);
            int r=((int) (Math.random()*(10000 - 1000))) + 1000;
            msg.setText("Enter this code to reset password: " + r);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com" , 465 , "shruthiiiscool@gmail.com", "sajju2000");
            transport.send(msg);
            return r;
        }
        catch(Exception exc) {
        	System.out.println("Exception");
            System.out.println(exc);
            System.out.println(exc.getMessage());
            return 0;
        }
    }
}