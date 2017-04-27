package tr.com.ceng.registration.service;

import tr.com.ceng.registration.model.User;

/**
 *
 * @author Cengizhan Ozcan
 */
public interface UserService {

	User findByUsername(String username);

}
