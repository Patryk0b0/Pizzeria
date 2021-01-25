package pl.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.model.HistoryItem;

@Repository
public class HistoryItemDaoImp implements HistoryItemDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer save(Integer history_id, String item) {
		HistoryItem historyItem = new HistoryItem();
		historyItem.setItem(item);
		historyItem.setHistory(history_id);
		
		sessionFactory.getCurrentSession().save(historyItem);
		return historyItem.getId();
	}

}
