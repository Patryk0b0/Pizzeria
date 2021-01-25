package pl.dao;

import java.util.List;

import pl.model.Addon;

public interface AddonDao {
	Addon get(Integer id);
	Addon get(String name);
	List<Addon> list();
}
