package com.practice.bmicalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practice.bmicalculator.model.User;
import com.practice.bmicalculator.service.BmiServiceImpl;

@Controller
public class BmiController {

	@Autowired
	private BmiServiceImpl bmiServiceImpl;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showBmiForm() {
		return "bmiForm.html";
	}

	@RequestMapping(value = "/getBMI", method = RequestMethod.GET)
	public String getBmi(@ModelAttribute("user") User user, ModelMap map) {
		double calculate = bmiServiceImpl.calculate(user);
		String bmiStatus = bmiServiceImpl.bmiStatus(calculate);
		map.addAttribute("bmiStatus", bmiStatus);
		map.addAttribute("calculate", calculate);
		return "bmiStatus";
	}
}
