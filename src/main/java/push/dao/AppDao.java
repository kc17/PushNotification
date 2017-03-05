package push.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import push.model.App;

@Repository
@Transactional
public class AppDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<App> list() {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM App")
				.getResultList();
	}

	public App get(Integer id) {
		return (App) sessionFactory.getCurrentSession()
				.createQuery("FROM App WHERE id=:id")
				.setParameter("id", id)
				.getSingleResult();
	}

}
