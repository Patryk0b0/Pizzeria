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

import pl.model.Soup;

@Repository
public class SoupDaoImp implements SoupDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Soup get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Soup get(String name) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Soup> query = builder.createQuery(Soup.class);
		Root<Soup> root = query.from(Soup.class);
		query.select(root).where(builder.equal(root.get("name"), name));
		Query<Soup> q = session.createQuery(query);
		return q.getSingleResult();
	}

	@Override
	public List<Soup> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Soup> cq = cb.createQuery(Soup.class);
		Root<Soup> root = cq.from(Soup.class);
		cq.select(root);
		Query<Soup> q = session.createQuery(cq);
		return q.getResultList();
	}

}
