package pl.service;

import java.util.List;

import pl.model.History;

public interface HistoryService {
	Integer save(String[] items, String name, String surname, String mail);
	List<History> list();
}
