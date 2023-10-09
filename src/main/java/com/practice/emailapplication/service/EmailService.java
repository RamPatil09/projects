package com.practice.emailapplication.service;

import com.practice.emailapplication.model.User;

public interface EmailService {

	public String createEmail(User user);
	
	public String generatePassword();
}
