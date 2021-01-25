package pl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dao.UserDetailsDao;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserDetailsDao userDetailsDao;
}
