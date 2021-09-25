package ord.padiss.mailsernder;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender {
	public static void main(String[] args) {

		// initialiser les propriétes
		Properties prop = new Properties();

		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.socketFactory.port", 465);
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

		// demarrer session avec le mail et le mot de passe
		// voudriez-vous remplacer mon mail par le mail expediteurs de vos mails
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("kalemajoseph39@gmail.com", "XXXXXX");
			}
		});

		// send the mail
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kalemajoseph39@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("kalemajoseph39@gmail.com"));
			message.setSubject("Mail Subject");

			String msg = "Bonjour A.T Jonathan";

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);

			message.setContent(multipart);

			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
