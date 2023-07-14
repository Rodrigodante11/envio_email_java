package enviando.email;


public class main {



    @org.junit.Test
    public void testeEmail() throws Exception{

        StringBuilder stringBuilderTextoEmail = new StringBuilder();

        stringBuilderTextoEmail.append("Olá, <br/><br/>");
        stringBuilderTextoEmail.append("Você está recebendo email pelo  ");
        stringBuilderTextoEmail.append("<span style=\"color:blue\"> JAVA <span> <br/><br/>" );
        stringBuilderTextoEmail.append("Para ter acesso clique no botão abaixo.<br/><br/>");

        stringBuilderTextoEmail.append("<b>Login:</b> blabla@jsjsjsj.com<br/>");
        stringBuilderTextoEmail.append("<b>Senha:</b> sdss8s98s<br/><br/>");

        stringBuilderTextoEmail.append("<a target=\"_blank\" href=\"http://projetojavaweb.com/certificado-aluno/login\" style=\"color:#2525a7; padding: 14px 25px; text-align:center; text-decoration: none; display:inline-block; border-radius:30px; font-size:20px; font-family:courier; border : 3px solid green;background-color:#99DA39;\">Acessar Portal do Aluno</a><br/><br/>");

        stringBuilderTextoEmail.append("<span style=\"font-size:8px\">Ass.: Rodrigo Dev</span>");


        EnviaEmail enviaEmail = new EnviaEmail(
                "coffeetechtcc@gmail.com",
                "lycxvgckzaeeywbz",
                "rodrigoaugusto839@gmail.com, rodrigoaugusto@gec.inatel.br",
                "Rodrigo Dev Full Stack",
                "Chegou e-mail enviado com java",
                stringBuilderTextoEmail.toString()
        );

        enviaEmail.enviarEmail(true);
        enviaEmail.enviarEmailAnexo(true);


    }
}
