package pl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.dao.DrinkDao;
import pl.model.Drink;

@Service
public class DrinkServiceImp implements DrinkService {

	@Autowired
	private DrinkDao drinkDao;
	
	@Transactional(readOnly = true)
	@Override
	public Drink get(Integer id) {
		return drinkDao.get(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Drink get(String name) {
		return drinkDao.get(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Drink> list() {
		return drinkDao.list();
	}

}
