package pl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.dao.HistoryDao;
import pl.model.History;

@Service
public class HistoryServiceImp implements HistoryService {

	@Autowired
	private HistoryDao historyDao;
	
	@Transactional(readOnly = false)
	@Override
	public Integer save(String[] items, String name, String surname, String mail) {
		return historyDao.save(items, name, surname, mail);
	}

	@Transactional(readOnly = true)
	@Override
	public List<History> list() {
		return historyDao.list();
	}

}
