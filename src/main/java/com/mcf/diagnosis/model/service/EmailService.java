package com.mcf.diagnosis.model.service;

import java.time.LocalDateTime;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
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

	@SuppressWarnings("finally")
	public Email sendEmail(Email email) {
		email.setSendDateEmail(LocalDateTime.now());
		 try {
			 
			MimeMessage mail = emailSender.createMimeMessage();
			MimeMessageHelper message = new MimeMessageHelper(mail, true);
			message.setFrom(email.getEmailFrom());
			message.setTo(email.getEmailTo());
			message.setSubject("Diagn&oacute;stico Financeiro - Pr&eacute;via");
			message.setText("<p><span style='font-family: \"Lucida Console\", Monaco, monospace; font-size: 14px;'>Boa noite, Sr. Afr&acirc;nio Alves de Jesus. Como vai?</span></p>\r\n"
					+ "<p><span style='font-family: \"Lucida Console\", Monaco, monospace; font-size: 14px;'>Segue a pr&eacute;via de sua sa&uacute;de financeira.</span></p>\r\n"
					+ "<p><span style='font-family: \"Lucida Console\", Monaco, monospace; font-size: 14px;'>Sua nota parcial foi&nbsp;<strong>95&nbsp;</strong>de 100 pontos.</span></p>\r\n"
					+ "<p><span style='font-family: \"Lucida Console\", Monaco, monospace; font-size: 14px;'>Isso significa que o seu diagn&oacute;stico est&aacute; classificado como: </span><span style='color: rgb(65, 168, 95); font-family: \"Lucida Console\", Monaco, monospace; font-size: 14px;'><strong>BEM ESTAR FINANCEIRO</strong><strong>.</strong></span></p>\r\n"
					+ "<p><span style='font-family: \"Lucida Console\", Monaco, monospace; font-size: 14px;'>Parab&eacute;ns por sua prosperidade financeira.</span></p>\r\n"
					+ "<p><span style=\"font-size: 14px;\"><a href=\"https://meuconsultorfinanceiro.com\"><span style=\"font-family: 'Lucida Console', Monaco, monospace;\">MeuConsultorFinanceiro.Com</span></a></span></p>", true);
			
			String value = email.getFile64().replaceFirst("^data:image/[^;]*;base64,?", "");
			byte[] bytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(value);
			message.addAttachment("PreviaDiagnosticoFinanceiro.jpg", new ByteArrayResource(bytes));
			 
			emailSender.send(mail);
			email.setStatusEmail(StatusEmail.SENT); 
			
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
