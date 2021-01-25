package pl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.dao.AddonDao;
import pl.model.Addon;

@Service
public class AddonServiceImp implements AddonService {

	@Autowired
	private AddonDao addonDao;
	
	@Transactional(readOnly = true)
	@Override
	public Addon get(Integer id) {
		return addonDao.get(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Addon get(String name) {
		return addonDao.get(name);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Addon> list() {
		return addonDao.list();
	}

}
