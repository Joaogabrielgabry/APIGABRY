package br.com.veterinaria.petgabry.services;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailService {

	@Autowired
	public JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String emailRemetente;
	
	@Value("${spring.mail.host}")
	private String emailServerHost;
	
	@Value("${spring.mail.port}")
	private Integer emailServerPort;
	
	@Value("${spring.mail.password}")
	private String emailPassword;
	
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setUsername(emailRemetente);
		mailSender.setHost(emailServerHost);
		mailSender.setPort(emailServerPort);
		mailSender.setPassword(emailPassword);
		
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		return mailSender;
	}
	
	public String writerTeste() {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("aqui coloca o email");
		message.setSubject("oi");
		message.setText("oi"  + localDateTime.format(formatter));
		
		try {
			javaMailSender.send(message);
			return"Email enviado com sucesso";
		} catch (Exception e){
			return "Erro ao enviar o Email" + e.getMessage();
		}
		
	}
	
	public String writerTeste2() {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setSubject("Teste email2");
			helper.setTo("joaocfw7@gmail.com");
			
			String emailText = "<h1>oioi</h1> "
								+"<p>oi</p>"
								+"<p>jgzin " + localDateTime.format(formatter) + "</p>"
								+"<br>";
			helper.setText(emailText, true);
			for (int i=0; i<3; i++) {
				javaMailSender.send(message);
			}
			return "Email enviado com sucesso";
		}catch(MessagingException e) {
			return "Erro ao enviar o Email" + e.getMessage();
		}
	}
	
	public String writerTeste3() {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat dec = new DecimalFormat("R$ #,##0.00");
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setSubject("aoba");
			helper.setTo("biamgabry@gmail.com");
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html>\r\n");
			sBuilder.append("	<body\r\n");
			sBuilder.append(localDateTime.format(formatter));
			sBuilder.append("		<div>\r\n");
			sBuilder.append("			<h1>que compra pae?</h1>\r\n");
			sBuilder.append("		</div>\r\n");
			sBuilder.append("		<br>\r\n");
			sBuilder.append("		<table border ='2' cellpadding = '2'>\r\n");
			sBuilder.append("			<tr><th>Nome</th><th>Preço</th><tr>\r\n");
			sBuilder.append("			<tr><td>trembolona</td><td>" + dec.format(5000000) +"</td><tr>\r\n");
			sBuilder.append("		</table>\r\n");
			sBuilder.append("	</body>\r\n");
			sBuilder.append("</html>");
			helper.setText(sBuilder.toString(), true);
			javaMailSender.send(message);
			return "Email enviado com sucesso";
		}catch(MessagingException e) {
			return "Erro ao enviar o Email" + e.getMessage();
		}
	}
}
