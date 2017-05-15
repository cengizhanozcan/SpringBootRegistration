package tr.com.ceng.registration.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.com.ceng.registration.model.Mail;
import tr.com.ceng.registration.model.User;
import tr.com.ceng.registration.repository.UserRepository;
import tr.com.ceng.registration.service.UserService;
import tr.com.ceng.registration.utils.LocaleUtils;

/**
 *
 * @author Cengizhan Ozcan
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	@Qualifier(value = "mailSenderService")
	private MailSenderService mailSenderService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsernameOrPassword(username, null);
	}

	@Override
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		if(user.getId() == null){
			userRepository.create(user);
			sendUserNotificationMail(user);
		} else {
			userRepository.update(user);
		}
		
		return user;
	}

	@Override
	public User findById(Long id) {
		if(id == null){
			return null;
		}
		
		return userRepository.findById(id);
	}

	@Override
	public List<User> search() {
		return userRepository.search();
	}

	private void sendUserNotificationMail(User user) {
		Mail mail = new Mail();
		mail.setSubject(messageSource.getMessage("mail.userRegistration.subject", 
				new Object[]{}, LocaleUtils.LOCALE_TR));
		mail.setBody(messageSource.getMessage("mail.userRegistration.body", 
				new Object[]{}, LocaleUtils.LOCALE_TR));
		List<String> tos = new ArrayList<String>();
		tos.add(user.getEmail());
		mail.setTos(tos);
		
		mailSenderService.send(mail);
	}

	@Override
	public User findByUsernameOrPassword(String username, String email) {
		return userRepository.findByUsernameOrPassword(username, email);
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

}
