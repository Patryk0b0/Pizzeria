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

import pl.model.Dish;

@Repository
public class DishDaoImp implements DishDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Dish get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dish get(String name) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Dish> query = builder.createQuery(Dish.class);
		Root<Dish> root = query.from(Dish.class);
		query.select(root).where(builder.equal(root.get("name"), name));
		Query<Dish> q = session.createQuery(query);
		return q.getSingleResult();
	}

	@Override
	public List<Dish> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Dish> cq = cb.createQuery(Dish.class);
		Root<Dish> root = cq.from(Dish.class);
		cq.select(root);
		Query<Dish> q = session.createQuery(cq);
		return q.getResultList();
	}

}
