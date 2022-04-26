package com.userstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userstore.domain.UserProgress;
import com.userstore.service.UserProgressService;

@RestController
@RequestMapping("/api/userstore/userprogress/")
public class UserProgressController {

	@Autowired
	private UserProgressService userprogresService;

	/*
	 * Create user progress by user id
	 */
	@PostMapping("{id}")
	public ResponseEntity<UserProgress> saveUserProgressByUserId(@RequestBody UserProgress userProgress,@PathVariable("id") long userId){
		return new ResponseEntity<UserProgress>(userprogresService.saveOrUpdatepdateUserProgressByUserId(userProgress, userId), HttpStatus.CREATED);
	}
	
    /*
     * Get user progress by user id
     */
	@GetMapping("{id}")
	public ResponseEntity<UserProgress> getUserProgressById(@PathVariable("id") long userId){
		return new ResponseEntity<UserProgress>(userprogresService.getUserProgressByUserId(userId), HttpStatus.OK);
	}
	
    /*
     * Update user progress by user id
     */
	@PutMapping("{id}")
	public ResponseEntity<UserProgress> updateUserProgresByUserId(@RequestBody UserProgress userProgress,@PathVariable("id") long userId){
		return new ResponseEntity<UserProgress>(userprogresService.saveOrUpdatepdateUserProgressByUserId(userProgress, userId), HttpStatus.OK);
	}
	
	
}
