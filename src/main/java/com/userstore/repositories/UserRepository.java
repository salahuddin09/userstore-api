package com.userstore.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.userstore.domain.User;
import com.userstore.domain.UserProgress;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<UserProgress> findAllById(Long id);
}
