package farmappceuticos.farmappcia.model;

import farmappceuticos.farmappcia.dto.Email;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionAsincrona implements Runnable{

    private Session session;


    private Email email;

    public NotificacionAsincrona(Email email) {
        this.email = email;
    }

    @Override
    public void run() {

sendMail(email);


    }


    public void initSesion(){
        //provide Mailtrap's username
        final String username = "api";
        //provide Mailtrap's password
        final String password = "b411b9132ea86b8cb2cbada15bfcbfd1";
        //provide Mailtrap's host address
        String host = "live.smtp.mailtrap.io";
        //configure Mailtrap's SMTP server details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        //create the Session object
        session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }


    public void sendMail(Email mail) {

        initSesion();
        try {
            //create a MimeMessage object
            Message message = new MimeMessage(session);
            //set From email field
            message.setFrom(new InternetAddress(mail.getRemitente()));
            //set To email field
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.getDestinatario()));
            //set email subject field
            message.setSubject(mail.getSubject());
            //set the content of the email message
            message.setText(mail.getMessage());
            //send the email message
            System.out.println("sendMail antes de Transport; " + mail.getMessage());
            Transport.send(message);
            System.out.println("Email Message Sent Successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

}
