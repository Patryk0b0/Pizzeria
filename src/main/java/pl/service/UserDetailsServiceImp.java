package pl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.dao.UserDetailsDao;
import pl.model.User;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	private UserDetailsDao userDetailsDao;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDetailsDao.get(username);
		UserBuilder builder = null;
		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
//			builder.disabled(!user.isEnabled());
//			builder.disabled(false);
			builder.password(user.getPassword());
			String[] authorities = user.getAuthorities().stream().map(a -> a.getAuthority()).toArray(String[]::new);
			
			
			builder.authorities(authorities);
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();
	}
	
}