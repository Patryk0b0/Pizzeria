package pl.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import pl.model.User;

@Repository
public class UserDetailsDaoImp implements UserDetailsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
	@Override
	public User get(String username) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root).where(cb.equal(root.get("username"), username));
		Query<User> query = session.createQuery(cq);
		return query.uniqueResult();
	}
	
}
