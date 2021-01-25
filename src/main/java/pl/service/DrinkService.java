package pl.service;

import java.util.List;

import pl.model.Drink;

public interface DrinkService {
	Drink get(Integer id);
	Drink get(String name);
	List<Drink> list();
}
