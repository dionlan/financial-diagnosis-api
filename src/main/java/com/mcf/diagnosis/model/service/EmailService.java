package com.mcf.diagnosis.model.service;

import java.time.LocalDateTime;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mcf.diagnosis.model.entity.Email;
import com.mcf.diagnosis.model.enums.StatusEmail;
import com.mcf.diagnosis.model.repository.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Value("${email.emailFrom}")
	private String emailFrom;

	@SuppressWarnings("finally")
	public Email sendEmail(Email email) {
		email.setSendDateEmail(LocalDateTime.now());
		email.setEmailFrom(emailFrom);
		email.setSubject("Diagnóstico Financeiro - Prévia");
		 try {
			 
			MimeMessage mail = emailSender.createMimeMessage();
			MimeMessageHelper message = new MimeMessageHelper(mail, true);
			message.setFrom(email.getEmailFrom());
			message.setTo(email.getEmailTo());
			message.setSubject(email.getSubject());
			message.setText("<p><span style='font-family: \"Lucida Console\", Monaco, monospace; font-size: 14px;'>Olá, "+email.getOwnerRef()+". Como vai?</span></p>\r\n"
					+ "<p><span style='font-family: \"Lucida Console\", Monaco, monospace; font-size: 14px;'>Segue a pr&eacute;via de sua sa&uacute;de financeira.</span></p>\r\n"
					+ "<p><span style=\"font-size: 14px;\"><a href=\"https://meuconsultorfinanceiro.com\"><span style=\"font-family: 'Lucida Console', Monaco, monospace;\">MeuConsultorFinanceiro.Com</span></a></span></p>", true);
			
			String value = email.getFile64().replaceFirst("^data:image/[^;]*;base64,?", "");
			byte[] bytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(value);
			message.addAttachment("PreviaDiagnosticoFinanceiro.jpg", new ByteArrayResource(bytes));
			
			email.setStatusEmail(StatusEmail.SENT);
			emailSender.send(mail);
			
			/*
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getEmailFrom());
			message.setTo(email.getEmailTo());
			message.setSubject(email.getSubject());
			message.setText("<p>Hello from Spring Boot Application</p>");
			emailSender.send(message);
			email.setStatusEmail(StatusEmail.SENT);*/
			 
		 }catch(MailException e) {
			 email.setStatusEmail(StatusEmail.ERROR);
			 
		 }finally {
			return emailRepository.save(email);
		}
	}
}
