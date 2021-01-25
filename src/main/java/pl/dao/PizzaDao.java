package pl.dao;

import java.util.List;

import pl.model.Pizza;

public interface PizzaDao {
	Pizza get(Integer id);
	Pizza get(String name);
	List<Pizza> list();
}
