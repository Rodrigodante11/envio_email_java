package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class main {

    private String userName = "coffeetechtcc@gmail.com";
    private String senha = "lycxvgckzaeeywbz";

    @org.junit.Test
    public void testeEmail() {


        try {

            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");/*Autorização*/
            properties.put("mail.smtp.starttls", "true"); /*Autenticação*/
            properties.put("mail.smtp.host", "smtp.gmail.com"); /*Sercidor gmail Google*/
            properties.put("mail.smtp.port", "465");/*Porta do servidor*/
            properties.put("mail.smtp.socketFactory.port", "465");/*Expecifica a porta a ser conectada pelo socket*/
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");/*Classe socket de conexão ao SMTP*/

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, senha);
                }
            });


            Address[] toUser = InternetAddress.parse("rodrigoaugusto839@gmail.com, rodrigoaugusto@gec.inatel.br");

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName)); /*Quem está enviano*/
            message.setRecipients(Message.RecipientType.TO, toUser);/*Email de destino*/
            message.setSubject("Chegou e-mail enviado com java");/*Assunto do e-mail*/
            message.setText("Olá programador, vc acaba de receber um e-mail enviado com Java ");


            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
