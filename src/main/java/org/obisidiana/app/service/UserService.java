package org.obisidiana.app.service;

import java.util.List;

import org.obisidiana.app.entity.User;
import org.obisidiana.app.repository.IUserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

	@Autowired
	IUserRepostory userRepository;

	@Override
	public List<User> getAllUser() {
		List<User> allUser = (List<User>)userRepository.findAll();
		return allUser;
	}

	@Override
	public User getUserById(long id) {
		
		return userRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("User doesn't exist whith the id: " + id));
	}

	@Override
	public boolean existUserByEmail(String email) {
		
		return userRepository.existsByEmail(email);
	}

	@Override
	public User setUser(User user) {
		if(existUserByEmail(user.getEmail()))
			throw new IllegalStateException("user already exist with the email: " + user.getEmail());
		User newUser = user;
		return userRepository.save(newUser);
	}
	
	

}
