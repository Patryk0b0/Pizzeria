package pl.dao;

import java.util.List;

import pl.model.Soup;

public interface SoupDao {
	Soup get(Integer id);
	Soup get(String name);
	List<Soup> list();
}
