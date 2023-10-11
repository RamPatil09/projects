package com.practice.user.service;

import java.util.List;

import com.practice.user.Model.User;
import com.practice.user.dto.UserDto;

public interface UserService {

	void saveUser(UserDto userDto);

	User findUserByEmail(String email);

	List<UserDto> findAllUsers();
}
