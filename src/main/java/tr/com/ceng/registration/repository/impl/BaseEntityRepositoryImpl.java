package tr.com.ceng.registration.repository.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tr.com.ceng.registration.model.BaseEntity;
import tr.com.ceng.registration.repository.BaseEntityRepository;

/**
 *
 * @author Cengizhan Ozcan
 */
@Repository
@Transactional
public class BaseEntityRepositoryImpl<T extends BaseEntity> implements BaseEntityRepository<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	@Autowired
	private EntityManager entityManager;
	
	private Class<T> type;

	@SuppressWarnings("unchecked")
	public BaseEntityRepositoryImpl() {
		try {
			this.type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		} catch (Exception e) {
			this.type = (Class<T>) BaseEntity.class;
		}
	}

	@Override
	public T create(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
		
		return entity;
	}

	@Override
	public T update(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
		
		return entity;
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	@Override
	public T findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.get(type, id);
	}

}
