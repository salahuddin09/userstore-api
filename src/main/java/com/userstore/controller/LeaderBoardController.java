package com.userstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userstore.repositories.UserProgressRepository;
import com.userstore.repositories.UserProgressRepository.LeaderBoardView;

@RestController
@RequestMapping("/api/userstore/leaderboard/")
public class LeaderBoardController {

	@Autowired
	private UserProgressRepository userprogressRepository;


	/*
	 * Get list of 10 user progress based on top score value
	 */
	@GetMapping("/users/")
	public List<LeaderBoardView> getUsersTopTenListByScore() {
		return (List<LeaderBoardView>) userprogressRepository.findUserListByScore(10);
	}
	
	/*
	 *   Get user score by user id
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<LeaderBoardView> getUserScoreByUserId(@PathVariable("id") long userId) {
		return new ResponseEntity<LeaderBoardView>(userprogressRepository.findUserScoreByUserId(userId), HttpStatus.OK);
	}

}
