package com.practice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.user.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
