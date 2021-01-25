package pl.dao;

import java.time.LocalDateTime;
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
import pl.model.History;
import pl.model.HistoryItem;

@Repository
public class HistoryDaoImp implements HistoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer save(String[] items, String name, String surname, String mail) {
		History history = new History();
		history.setName(name);
		history.setSurname(surname);
		history.setMail(mail);
		history.setDate(LocalDateTime.now());
		
		sessionFactory.getCurrentSession().save(history);
		
		return history.getId();
	}

	@Override
	public List<History> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<History> cq = cb.createQuery(History.class);
		Root<History> root = cq.from(History.class);
		cq.select(root);
		Query<History> q = session.createQuery(cq);
		return q.getResultList();
	}

}
