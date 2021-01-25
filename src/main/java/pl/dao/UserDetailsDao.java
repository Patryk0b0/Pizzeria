package pl.dao;

import pl.model.User;

public interface UserDetailsDao {
	User get(String username);
}
