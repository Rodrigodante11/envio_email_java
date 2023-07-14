package enviando.email;


public class main {


    @org.junit.Test
    public void testeEmail() throws Exception{
        EnviaEmail enviaEmail = new EnviaEmail(
                "coffeetechtcc@gmail.com",
                "lycxvgckzaeeywbz",
                "rodrigoaugusto839@gmail.com, rodrigoaugusto@gec.inatel.br",
                "Rodrigo Dev Full Stack",
                "Chegou e-mail enviado com java",
                "Olá programador, vc acaba de receber um e-mail enviado com Java "
        );

        enviaEmail.enviarEmail();


    }
}
