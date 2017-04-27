package tr.com.ceng.registration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.ceng.registration.model.User;
import tr.com.ceng.registration.repository.UserRepository;
import tr.com.ceng.registration.service.UserService;

/**
 *
 * @author Cengizhan Ozcan
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

}
