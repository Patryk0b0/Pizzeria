package pl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.dao.DishDao;
import pl.model.Dish;

@Service
public class DishServiceImp implements DishService {

	@Autowired
	private DishDao dishDao;

	@Transactional(readOnly = true)
	@Override
	public Dish get(Integer id) {
		return dishDao.get(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Dish get(String name) {
		return dishDao.get(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Dish> list() {
		return dishDao.list();
	}

}
