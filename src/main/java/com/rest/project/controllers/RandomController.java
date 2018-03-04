package com.rest.project.controllers;

import java.util.Random;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {

	@RequestMapping("/randomNum")
	public int randomNum(@RequestParam(value = "min", defaultValue = "0") String min,
			@RequestParam(value = "max", defaultValue = "100") String max) {

		int minNum=0;
		int maxNum=0;
		
		if (isInteger(min) == false || isInteger(max) == false) {
			throw new IllegalArgumentException("Please ensure you enter a numeric value for both Minimum and Maximum");
		} else {
			 minNum = Integer.parseInt(min);
			 maxNum = Integer.parseInt(max);
		}
		return getRandomNumberWithRange(minNum, maxNum);
	}

	private int getRandomNumberWithRange(int min, int max) {
		// ensure maximum is never less than minimum
		if (min >= max)
			throw new IllegalArgumentException("The Max number must be greater than the Min number");

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	//test if a string can be parsed as an integer
	public boolean isInteger(String stringToTest) {
		try {
			Integer.valueOf(stringToTest);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
