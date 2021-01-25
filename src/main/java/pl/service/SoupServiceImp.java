package pl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.dao.SoupDao;
import pl.model.Soup;

@Service
public class SoupServiceImp implements SoupService {

	@Autowired
	private SoupDao soupDao;
	
	@Transactional(readOnly = true)	
	@Override
	public Soup get(Integer id) {
		return soupDao.get(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Soup get(String name) {
		return soupDao.get(name);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Soup> list() {
		return soupDao.list();
	}

}
