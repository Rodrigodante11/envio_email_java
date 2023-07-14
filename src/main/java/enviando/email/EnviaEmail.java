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

public class EnviaEmail {

    private String userName ;
    private String senha  ; //"123456Ro@"
    private String listaDestinatario ;
    private String nomeRemetente ;
    private String assuntoEmail ;
    private String textEmail ;


    public EnviaEmail(String userName, String senha, String listaDestinatario, String nomeRemetente, String assuntoEmail, String textEmail) {
        this.userName = userName;
        this.senha = senha;
        this.listaDestinatario = listaDestinatario;
        this.nomeRemetente = nomeRemetente;
        this.assuntoEmail = assuntoEmail;
        this.textEmail = textEmail;
    }

    public void enviarEmail(boolean envioHtml){

        try {

            Properties properties = new Properties();

            properties.put("mail.smtp.ssl.trust","*");
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


            Address[] toUser = InternetAddress.parse(listaDestinatario);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName, nomeRemetente)); /*Quem está enviano*/
            message.setRecipients(Message.RecipientType.TO, toUser);/*Email de destino*/
            message.setSubject(assuntoEmail);/*Assunto do e-mail*/


            if (envioHtml){
                message.setContent(textEmail, "text/html; charset=utf-8");

            }else{
                message.setText(textEmail);
            }

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
