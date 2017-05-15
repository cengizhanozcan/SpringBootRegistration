package tr.com.ceng.registration.service;

import java.util.List;

import tr.com.ceng.registration.model.User;

/**
 *
 * @author Cengizhan Ozcan
 */
public interface UserService {

	User findByUsername(String username);

	User save(User user);

	User findById(Long id);

	List<User> search();

	User findByUsernameOrPassword(String username, String email);

	void delete(User user);

}
