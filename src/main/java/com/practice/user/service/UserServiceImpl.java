package com.practice.user.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.practice.user.Model.ERole;
import com.practice.user.Model.Role;
import com.practice.user.Model.User;
import com.practice.user.dto.UserDto;
import com.practice.user.repository.RoleRepository;
import com.practice.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getFirstName() + " " + userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setContactNumber(userDto.getContactNumber());
		user.setPassword(userDto.getPassword());
		String role2 = userDto.getRole();
		if (role2 == null) {
			role2 = ERole.ROLE_USER.name();
		}
		Role role = roleRepository.findByName(role2);

		if (role == null) {
			role = checkRoleExist();
		}

		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<UserDto> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map((user) -> mapToUserDto(user)).collect(Collectors.toList());
	}

	private UserDto mapToUserDto(User user) {
		UserDto dto = new UserDto();
		String[] str = user.getName().split(" ");
		dto.setFirstName(str[0]);
		dto.setLastName(str[1]);
		dto.setEmail(user.getEmail());
		dto.setContactNumber(user.getContactNumber());
		return dto;
	}

	private Role checkRoleExist() {
		Role role = new Role();
		role.setName("ROLE_ADMIN");
		role.setName("ROLE_USER");
		return roleRepository.save(role);
	}

}
