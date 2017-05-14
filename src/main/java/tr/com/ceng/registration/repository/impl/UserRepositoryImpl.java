package tr.com.ceng.registration.repository.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
	public User findByUsernameOrPassword(String username, String email) {
		StringBuilder builder = new StringBuilder("FROM User WHERE 1=1 ");
		if(StringUtils.isNotEmpty(username)){
			builder.append(" AND username=:username ");
		}
		if(StringUtils.isNotEmpty(email)){
			builder.append(" AND email=:email ");
		}
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(builder.toString());

		if(StringUtils.isNotEmpty(username)){
			query.setParameter("username", username);
		}
		if(StringUtils.isNotEmpty(email)){
			query.setParameter("email", email);
		}
		
		List<User> users = query.list();
		if(users != null && !users.isEmpty()){
			return users.get(0);
		}
		
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> search() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM User").list();
	}
	
}
