package pl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.dao.PizzaDao;
import pl.model.Pizza;

@Service
public class PizzaServiceImp implements PizzaService {

	@Autowired
	private PizzaDao pizzaDao;
	
	@Transactional(readOnly = true)
	@Override
	public Pizza get(Integer id) {
		return pizzaDao.get(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Pizza get(String name) {
		return pizzaDao.get(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Pizza> list() {
		return pizzaDao.list();
	}

}
