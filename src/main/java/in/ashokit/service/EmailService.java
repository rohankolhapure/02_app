package in.ashokit.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public boolean sendEmail(String to, String subject, String body) {
		boolean isSent = false;
		try {
			/*
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(to);
			msg.setSubject(subject);
			msg.setText(body);*/
			
			MimeMessage msg = mailSender.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(msg);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
			
			//helper.addAttachment("Report", new File("path-of-file"));
			
			mailSender.send(msg);
			isSent = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
	}
}
