package pl.service;

import java.util.List;

import pl.model.Soup;

public interface SoupService {
	Soup get(Integer id);
	Soup get(String name);
	List<Soup> list();
}
