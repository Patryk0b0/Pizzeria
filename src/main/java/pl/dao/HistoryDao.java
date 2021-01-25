package pl.dao;

import java.util.List;

import pl.model.History;

public interface HistoryDao {
	History get(Integer id);
	Integer save(String[] items, String name, String surname, String mail);
	List<History> list();
}
