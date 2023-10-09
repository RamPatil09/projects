package com.practice.emailapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practice.emailapplication.model.User;
import com.practice.emailapplication.service.EmailServiceImpl;

@Controller
public class UserController {
	@Autowired
	private EmailServiceImpl emailServiceImpl;

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String homePage() {
		return "index.html";
	}

	@RequestMapping(value = { "/details" }, method = RequestMethod.GET)
	public String createEmail(@ModelAttribute("user") User user, Model map) {
		String email = emailServiceImpl.createEmail(user);
		String password = emailServiceImpl.generatePassword();
		map.addAttribute("email", email);
		map.addAttribute("password", password);
		map.addAttribute("department", user.getDepartment());
		map.addAttribute("alternateEmail", user.getAlternateEmail());
		return "details";
	}
}
