package tr.com.ceng.registration.repository;

import tr.com.ceng.registration.model.BaseEntity;

/**
 *
 * @author Cengizhan Ozcan
 */
public interface BaseEntityRepository <T extends BaseEntity>{

	public T create(T entity);
	public T update(T entity);
	public void delete(T entity);
	public T findById(Long id);
}
