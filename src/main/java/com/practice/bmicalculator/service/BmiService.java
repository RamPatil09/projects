package com.practice.bmicalculator.service;

import com.practice.bmicalculator.model.User;

public interface BmiService {

	public double calculate(User user);
	
	public String bmiStatus(double bmi);
}
