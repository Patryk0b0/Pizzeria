package pl.dao;

import java.util.List;

import pl.model.Drink;

public interface DrinkDao {
	Drink get(Integer id);
	Drink get(String name);
	List<Drink> list();
}
