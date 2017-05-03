package tr.com.ceng.registration.repository;

import java.util.List;

import tr.com.ceng.registration.model.User;

/**
 *
 * @author Cengizhan Ozcan
 */
public interface UserRepository extends BaseEntityRepository<User>{

	User findByUsername(String username);

	List<User> search();

}
