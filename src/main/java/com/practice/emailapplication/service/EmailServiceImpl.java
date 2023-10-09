package com.practice.emailapplication.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import com.practice.emailapplication.model.User;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public String createEmail(User user) {
		String firstName = user.getFirstName().toLowerCase();
		String lastName = user.getLastName().toLowerCase();
		String org = "dummy.com";
		return firstName + "." + lastName + "@" + org;
	}

	@Override
	public String generatePassword() {
		String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";

		SecureRandom random = new SecureRandom();
		int length = 8;
		StringBuilder password = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(allowedCharacters.length());
			char randomChar = allowedCharacters.charAt(randomIndex);
			password.append(randomChar);
		}
		return password.toString();
	}

}
