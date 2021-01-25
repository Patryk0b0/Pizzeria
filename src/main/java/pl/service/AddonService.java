package pl.service;

import java.util.List;

import pl.model.Addon;

public interface AddonService {
	Addon get(Integer id);
	Addon get(String name);
	List<Addon> list();
}
