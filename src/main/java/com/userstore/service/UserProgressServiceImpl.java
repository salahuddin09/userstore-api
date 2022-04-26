package com.userstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userstore.domain.User;
import com.userstore.domain.UserProgress;
import com.userstore.exceptions.UserStoreException;
import com.userstore.repositories.UserProgressRepository;
import com.userstore.repositories.UserRepository;

@Service
public class UserProgressServiceImpl implements UserProgressService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProgressRepository userProgressRepository;

	@Override
	public UserProgress getUserProgressByUserId(Long userId) throws UserStoreException {

		User user = userRepository.findById(userId).orElseThrow(() -> new UserStoreException("User not found!"));
 
		Optional<UserProgress> userProgress = null;
		
		if (user !=null && user.getUserProgress() != null && user.getUserProgress().getId() != null) {
		  userProgress = userProgressRepository.findById(user.getUserProgress().getId());
		}
		
		return userProgress.get(); 
	}
	
	@Override
	public UserProgress saveOrUpdatepdateUserProgressByUserId(UserProgress userProgress , Long userId){
        try {
        	
    		User user = userRepository.findById(userId).orElseThrow(() -> new UserStoreException("User not found!"));
    		UserProgress updated = new UserProgress();
    		
        	if (user.getUserProgress() != null && user.getUserProgress().getId() != null)
        		updated.setId(user.getUserProgress().getId());
        	
        	updated.setLevel(userProgress.getLevel());
        	updated.setScore(userProgress.getScore());
        	updated = userProgressRepository.save(updated);
        	
        	if(updated != null) {
        		user.setId(userId);
        		user.setUserProgress(updated);
        		userRepository.save(user);
        	}
        	
            return updated;
        } catch (Exception e ){
            throw new UserStoreException("User Progress not save!");
        }
    }
	

}
