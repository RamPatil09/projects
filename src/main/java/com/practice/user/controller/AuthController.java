package com.practice.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practice.user.Model.User;
import com.practice.user.dto.UserDto;
import com.practice.user.service.UserServiceImpl;

import jakarta.validation.Valid;

@Controller
public class AuthController {

	private UserServiceImpl userServiceImpl;

	public AuthController(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "index.html";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
		return "register";
	}

	@RequestMapping(value = "/register/save", method = RequestMethod.POST)
	public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
		User existingUser = userServiceImpl.findUserByEmail(userDto.getEmail());

		if (existingUser != null && existingUser.getEmail() != null && existingUser.getEmail().isEmpty()) {
			result.rejectValue("email", null, "There is already an account registered with the same email");
		}

		if (result.hasErrors()) {
			model.addAttribute("user", userDto);
			return "/register";
		}

		userServiceImpl.saveUser(userDto);
		return "redirect:/home";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

}
