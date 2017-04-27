package tr.com.ceng.registration.repository;

import tr.com.ceng.registration.model.User;

/**
 *
 * @author Cengizhan Ozcan
 */
public interface UserRepository extends BaseEntityRepository<User>{

	User findByUsername(String username);

}
