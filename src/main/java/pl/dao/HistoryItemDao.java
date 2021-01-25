package pl.dao;

import pl.model.History;

public interface HistoryItemDao {
	Integer save(Integer history_id, String item);
	
	
}
