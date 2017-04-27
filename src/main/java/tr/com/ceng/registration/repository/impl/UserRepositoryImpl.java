package tr.com.ceng.registration.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tr.com.ceng.registration.model.User;
import tr.com.ceng.registration.repository.UserRepository;

/**
 *
 * @author Cengizhan Ozcan
 */
@Repository
@Transactional
public class UserRepositoryImpl extends BaseEntityRepositoryImpl<User> implements UserRepository {

	@Override
	public User findByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM registration.user_user WHERE username=:username ");
		query.setParameter("username", username);
		
		List<User> users = query.list();
		if(users != null && !users.isEmpty()){
			return users.get(0);
		}
		
		return null;
	}

	
}
