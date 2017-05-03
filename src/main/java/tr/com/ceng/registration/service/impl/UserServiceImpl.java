package tr.com.ceng.registration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.com.ceng.registration.model.User;
import tr.com.ceng.registration.repository.UserRepository;
import tr.com.ceng.registration.service.UserService;

/**
 *
 * @author Cengizhan Ozcan
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(User user) {
		validateBeforeSave(user);
		if(user.getId() == null){
			userRepository.create(user);
		} else {
			userRepository.update(user);
		}
		
		return user;
	}

	private void validateBeforeSave(User user) {
		// TODO Auto-generated method stub
		
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

}
