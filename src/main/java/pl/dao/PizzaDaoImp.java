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

import pl.model.Pizza;

@Repository
public class PizzaDaoImp implements PizzaDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Pizza get(Integer id) {

		return null;
	}

	@Override
	public Pizza get(String name) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Pizza> query = builder.createQuery(Pizza.class);
		Root<Pizza> root = query.from(Pizza.class);
		
		System.out.println(name);
		
		
		
		query.select(root).where(builder.equal(root.get("name"), name));
		Query<Pizza> q = session.createQuery(query);
		
		
		
		
		return q.getSingleResult();
	}

	@Override
	public List<Pizza> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Pizza> cq = cb.createQuery(Pizza.class);
		Root<Pizza> root = cq.from(Pizza.class);
		cq.select(root);
		Query<Pizza> q = session.createQuery(cq);
		return q.getResultList();
	}

}
