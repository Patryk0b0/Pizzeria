package pl.dao;

import java.util.List;

import pl.model.Dish;

public interface DishDao {
	Dish get(Integer id);
	Dish get(String name);
	List<Dish> list();
}
