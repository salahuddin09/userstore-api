package com.userstore.service;

import com.userstore.domain.UserProgress;
import com.userstore.exceptions.UserStoreException;

public interface UserProgressService {
	
	public UserProgress getUserProgressByUserId(Long userId) throws UserStoreException;
	
	public UserProgress saveOrUpdatepdateUserProgressByUserId(UserProgress userProgress,Long userId);
	
}
