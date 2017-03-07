package push.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import push.model.App;

@Repository
@Transactional
public class AppDao {

	@Inject
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<App> list() {
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM App")
				.getResultList();
	}

	public App get(Long id) {
		return (App) sessionFactory
				.getCurrentSession()
				.createQuery("FROM App WHERE id=:id")
				.setParameter("id", id)
				.getSingleResult();
	}
	
	public void save(App app) {
		sessionFactory.getCurrentSession().save(app);
	}
	
	public void update(App app) {
		sessionFactory.getCurrentSession().saveOrUpdate(app);
	}


}
