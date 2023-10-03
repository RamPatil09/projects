package com.practice.bmicalculator.service;

import org.springframework.stereotype.Service;

import com.practice.bmicalculator.model.User;

@Service
public class BmiServiceImpl implements BmiService {

	@Override
	public double calculate(User user) {
		double height = user.getHeight() / 100;
		double weight = user.getWeight();
		double bmi = (weight) / (height * height);
		return Math.round(bmi);
	}

	@Override
	public String bmiStatus(double bmi) {

		if (bmi < 16) {
			return "Severely underweight";
		} else if (bmi >= 16 && bmi <= 18.4) {
			return "Underweight";
		} else if (bmi >= 18.5 && bmi <= 24.9) {
			return "Normal (healthy weight)";
		} else if (bmi >= 25 && bmi < 29.9) {
			return "Overweight";
		} else {
			return "Obese";
		}

	}

}
