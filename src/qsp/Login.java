package qsp;



import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Login extends Authenticator{

	public PasswordAuthentication getPasswordAuthentication()
	{
		PasswordAuthentication p=new PasswordAuthentication("lavanyarvis041@gmail.com", "9663089998l");
		return p;
		
	}
	
	
}

