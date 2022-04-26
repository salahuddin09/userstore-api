package com.userstore.service;

import com.userstore.domain.User;
import com.userstore.exceptions.UserStoreException;

public interface UserService {

	public User getUserById(Long id) throws UserStoreException;
	
	public User saveUser(User user);
	
	public User updateUser(User user);
	
}
