package tr.com.ceng.registration.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import tr.com.ceng.registration.model.Mail;

/**
 *
 * @author Cengizhan Ozcan
 */
@Component(value = "mailSenderService")
public class MailSenderService implements Serializable{

	@Value("${spring.mail.username}")
	private String mailAddress;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	public void send(Mail mail){
		if(mail == null){
			return;
		}
		
		MimeMessagePreparator messagePreparator = mimeMessage -> {
	        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
	        messageHelper.setFrom(mailAddress);
	        messageHelper.setTo(getTos(mail));
	        messageHelper.setSubject(mail.getSubject());
	        messageHelper.setText(mail.getBody());
	    };
	    
	    mailSender.send(messagePreparator);
	}

	private InternetAddress[] getTos(Mail mail)  {
		List<InternetAddress> tos = new ArrayList<InternetAddress>();
		if(mail.getTos() == null){
			return null;
		}
		
		try {
			for(String to : mail.getTos()){
				tos.add(new InternetAddress(to));
			}
			InternetAddress[] tosArray = new InternetAddress[tos.size()];
			
			return tos.toArray(tosArray);
		} catch (AddressException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
