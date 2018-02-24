package qsp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

	public static void main(String[] args) throws Exception  {
	//7.Load property file(email settings)	
		Properties p=new Properties();
		p.load(new FileInputStream("./settings.properties"));
		//8.Create a session
		Session session=Session.getInstance(p, new Login());
		//9.Create a mail(MimeMessage)
		MimeMessage mail=new MimeMessage(session);
        //10.addRecipient
		String email="lavanyarvis041@gmail.com";
		InternetAddress to=new InternetAddress(email);
		mail.addRecipient(RecipientType.TO,to);
		//11.set Subject
		mail.setSubject("Test Mail");
		//12.SetText(email body)
		mail.setText("Hi,thanks......");
		
		
		//--------------------------------------------------------
		
		Multipart multiPart=new MimeMultipart();
		MimeBodyPart bp=new MimeBodyPart();
		DataSource source=new FileDataSource("./report.log");
		bp.setDataHandler(new DataHandler(source));
		bp.setFileName("report");
		multiPart.addBodyPart(bp);
		mail.setContent(multiPart);
		//------------
		
		
		//13.send email
		Transport.send(mail);
		System.out.println("Done");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
