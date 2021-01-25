package pl.service;

import java.util.List;

import pl.model.Pizza;

public interface PizzaService {
	Pizza get(Integer id);
	Pizza get(String name);
	List<Pizza> list();
}
