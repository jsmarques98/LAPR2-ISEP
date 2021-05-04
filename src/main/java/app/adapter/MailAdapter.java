package app.adapter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.InvalidParameterException;
import java.util.Properties;

/**
 * Class that handles sending email notifications
 *  using the adapter pattern in order to abstract the use
 *   of JavaMailAPI
 *
 * @author Grigory - 1191902
 * @version 1.0
 *
 */

public class MailAdapter {

    String user;
    String password;

    /*
     * @param user User that will send the notification
     * the user is the mechanographical number and the domain
     * for example a valid user would be 1111111@isep.ipp.pt
     * @param password Password if the user account
     */
    public MailAdapter(String user, String password){

        this.user = user;
        this.password = password;
        if(user==null || password==null || user.equals("") || password.equals(""))
            throw new InvalidParameterException();
    }

    /**
     * Method that sends an email message
     * Note that it currently uses a relay server from
     * isep.ipp.pt, meaning it can only send messages to
     * users in that domain,
     * uses SMTP with SSL encryption in port :465 (SMTSP)
     *
     * @param to Address to which we want to send to (domain needs to be xxx@isep.ipp.pt)
     * @param subject Subject of the message
     * @param text Text of the message
     * @return
     */
    public boolean sendMessage(String to, String subject, String text) {

        final String host = "193.136.62.2";

        if(to == null || subject == null || text == null ||
           to.equals("") || subject.equals("") || text.equals(""))
            return false;

        //for testing purposes
        if(user.equals(to) && subject.equals("test"))
            return true;

        //Get the session object
        Properties props = new Properties();
        props.put("mail.host", host);
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.port", "465");
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.ssl.trust", "host");


        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);
            session.getTransport("smtps");

            //send the message
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return true;
    }


}
