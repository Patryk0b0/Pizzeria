package pl.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.model.Addon;
import pl.model.Dish;

@Repository
public class AddonDaoImp implements AddonDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Addon get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Addon> query = builder.createQuery(Addon.class);
		Root<Addon> root = query.from(Addon.class);
		query.select(root).where(builder.equal(root.get("id"), id));
		Query<Addon> q = session.createQuery(query);
		return q.getSingleResult();
	}

	@Override
	public Addon get(String name) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Addon> query = builder.createQuery(Addon.class);
		Root<Addon> root = query.from(Addon.class);
		query.select(root).where(builder.equal(root.get("name"), name));
		Query<Addon> q = session.createQuery(query);
		return q.getSingleResult();
	}

	@Override
	public List<Addon> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
