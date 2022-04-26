package com.userstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userstore.domain.User;
import com.userstore.exceptions.UserStoreException;
import com.userstore.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserById(Long id) throws UserStoreException {
		User user = userRepository.findById(id).orElseThrow(() -> new UserStoreException("User not found!"));
		return user;
	}

	@Override
	public User saveUser(User user) {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new UserStoreException("User not save!");
		}
	}

	@Override
	public User updateUser(User user) {
		try {

			User updated = getUserById(user.getId());
			updated.setName(user.getName());
			updated.setCountry(user.getCountry());
			updated.setUserProgress(user.getUserProgress());

			return userRepository.save(updated);

		} catch (Exception e) {
			throw new UserStoreException("User not found!");
		}
	}
}
