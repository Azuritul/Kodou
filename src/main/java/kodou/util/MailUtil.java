package kodou.util;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {

    public void sendMail(final String from, final String[] to, final String password, final String messageSubject, final String messageBody) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        Session session = Session.getInstance(props, auth);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            for (String toAddress : to) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            }
            message.setSubject(messageSubject);
            message.setText(messageBody);
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
