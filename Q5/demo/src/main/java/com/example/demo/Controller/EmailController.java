package com.example.demo.Controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@RestController

public class EmailController {
    @Scheduled(cron = "0 * 8 * * ?")
    public void cronJobSch() throws IOException, MessagingException {
        sendmail();
        }

    @RequestMapping(value = "/sendemail")
    public String sendEmail() {
        return "Email sent successfully";
    }
    private void sendmail() throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("assignment5nuclei@gmail.com", "piyush_mehta24");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("assignment5nuclei@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("akashpandey920@gmail.com"));
        msg.setSubject("chal gaya");
        msg.setContent("chal gaya", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Chal gaya", "text/html");
        Transport.send(msg);
    }

}
