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

import pl.model.Drink;

@Repository
public class DrinkDaoImp implements DrinkDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Drink get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Drink get(String name) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Drink> query = builder.createQuery(Drink.class);
		Root<Drink> root = query.from(Drink.class);
		query.select(root).where(builder.equal(root.get("name"), name));
		Query<Drink> q = session.createQuery(query);
		return q.getSingleResult();
	}

	@Override
	public List<Drink> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Drink> cq = cb.createQuery(Drink.class);
		Root<Drink> root = cq.from(Drink.class);
		cq.select(root);
		Query<Drink> q = session.createQuery(cq);
		return q.getResultList();
	}

}
