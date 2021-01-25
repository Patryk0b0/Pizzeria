package pl.service;

import java.util.List;

import pl.model.Dish;

public interface DishService {
	Dish get(Integer id);
	Dish get(String name);
	List<Dish> list();
}
