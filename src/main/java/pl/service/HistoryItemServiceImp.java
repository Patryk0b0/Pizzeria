package pl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.dao.HistoryItemDao;

@Service
public class HistoryItemServiceImp implements HistoryItemService {

	@Autowired
	private HistoryItemDao historyItemDao;
	

	@Transactional(readOnly = false)	
	@Override
	public Integer save(Integer history_id, String item) {
		return historyItemDao.save(history_id, item);
	}

}
