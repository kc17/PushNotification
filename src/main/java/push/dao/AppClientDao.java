package push.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import push.model.AppClient;

@Repository
@Transactional
public class AppClientDao {

	@Inject
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<AppClient> listByAppId(Long appId) {
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM AppClient WHERE app.id=:appId")
				.setParameter("appId", appId)
				.getResultList();
	}
	
	public AppClient get(Long id) {
		return (AppClient) sessionFactory
				.getCurrentSession()
				.createQuery("FROM AppClient WHERE id=:id")
				.setParameter("id", id)
				.getSingleResult();
	}
	
	public AppClient get(String  registrationId) {
		return (AppClient) sessionFactory
				.getCurrentSession()
				.createQuery("FROM AppClient WHERE registrationId=:registrationId")
				.setParameter("registrationId", registrationId)
				.getSingleResult();
	}
	
	public void save(AppClient appClient) {
		sessionFactory.getCurrentSession().save(appClient);
	}
	
	public void update(AppClient appClient) {
		sessionFactory.getCurrentSession().saveOrUpdate(appClient);
	}
	
}
