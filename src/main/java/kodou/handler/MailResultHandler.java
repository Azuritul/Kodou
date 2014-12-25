package kodou.handler;

import kodou.model.CheckResult;
import kodou.model.Site;
import kodou.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class MailResultHandler implements ResultHandler {

    @Autowired
    private Environment env;
    @Autowired
    private MailSender mailSender;

    @Override
    public void execute(final CheckResult result) {
        Site site = result.getSite();
        String account = env.getProperty("mail.account");
        String password = env.getProperty("mail.password");
        String[] receipient = env.getProperty("mail.receipient").split(",");
        System.out.println(String.format("acc: %s,  pass: %s", account, password));

        if (site != null) {
            final String subject = String.format("[KODOU] Alert! Your website(%s) is %s", site.getUrl(), result.getCode());
            final String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPAN).format(new Date(result.getTimestamp()));
            final String textBody = String.format("On [%s] the target website: %s(%s) is %s", time, site.getName(), site.getUrl(), result.getCode());
            MailUtil mailUtil = new MailUtil();
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setSubject(subject);
            mailMessage.setText(textBody);
            mailMessage.setTo(receipient);
            mailSender.send(mailMessage);
            mailUtil.sendMail(account, receipient, password, subject, textBody);
        }
    }
}
