package util;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.util.*;

public class Utils {

    public static void sendEmail(String address, String subject, String text){
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("./src/main/resources/Mail.properties"));
            Session session = Session.getDefaultInstance(props);

            MimeMessage message = new MimeMessage(session);
            message.setSubject(subject);
            message.setText(text);
            message.setFrom(props.getProperty("mail.user"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(address));
            message.setSentDate(new Date());

            Transport transport = session.getTransport();
            transport.connect(props.getProperty("mail.host"), 587, props.getProperty("mail.user"), props.getProperty("mail.password"));
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        }catch (MessagingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
