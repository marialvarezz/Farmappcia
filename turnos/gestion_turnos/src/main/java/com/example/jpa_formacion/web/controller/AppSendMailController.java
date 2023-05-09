/**
 * 
 */
package com.example.jpa_formacion.web.controller;



import com.example.jpa_formacion.service.MenuService;
import com.example.jpa_formacion.service.UsuarioService;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Properties;


/**
 * 
 * @author rutpatel
 *
 */
@Controller
public class AppSendMailController extends  AbstractControllerMenu {
	private Session session;
	private final Properties properties = new Properties();
	private String password = "EOIGrupo4";
	UsuarioService service;
	@Autowired
	private JavaMailSender sender;

	protected AppSendMailController(MenuService menuService) {
		super(menuService);
	}
	private void init() {

		//ssl
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");

		session = Session.getDefaultInstance(properties,
				new jakarta.mail.Authenticator(){
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("appfeelingcare@gmail.com",password);
					}
				});
	}

	@GetMapping("/email/emailsimple")
	public ModelAndView doGetSendMail() {
		String to="jose.manuel.aroca@hotmail.com";
		String text="Hola prueba de envío";
		String subject="test email";
		return doPostSendMail(to, text, subject);
	}

	@PostMapping("/email/emailsimple")
	public ModelAndView doPostSendMail(@RequestParam String to,@RequestParam  String text,@RequestParam  String subject) {
		ModelAndView mv = null;
		String resultaEnvio = "";
		mv = new ModelAndView("email/emailsimple");

		/*
		MimeMessage message = sender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setTo(to);
			helper.setText(text);
			helper.setSubject(subject);
			sender.send(message);
			resultaEnvio=  "Mensaje enviado correctamente";
		} catch (MessagingException e) {
			e.printStackTrace();
			resultaEnvio=  "Error while sending mail ..";
		}

		*/
		init();

		//ssl
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("appfeelingcare@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("jose.manuel.aroca@hotmail.com"));
			message.setSubject(subject);
			message.setText(text);
			Transport t = session.getTransport("smtp");
			t.connect("smtp.gmail.com", "appfeelingcare@gmail.com", password);
			t.sendMessage(message, message.getAllRecipients());

			System.out.println("Done");
			resultaEnvio = "done";

		} catch (MessagingException e) {

			resultaEnvio = e.toString();
		}

		mv.addObject("resultado", resultaEnvio);
		//mv.addObject("year", year);
		//mv.addObject("month", mo);

		return mv;
	}

}
