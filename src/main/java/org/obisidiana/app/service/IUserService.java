package org.obisidiana.app.service;

import java.util.List;

import org.obisidiana.app.entity.User;

public interface IUserService {

	public List<User> getAllUser();
	
	public User getUserById(long id);
	
	public boolean existUserByEmail(String email);
	
	public User setUser(User user);
	
}
