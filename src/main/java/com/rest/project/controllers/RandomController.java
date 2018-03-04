package com.rest.project.controllers;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {

	@RequestMapping("/randomNum")
	public ResponseEntity<String> randomNum(@RequestParam(value = "min", defaultValue = "0") String min,
			@RequestParam(value = "max", defaultValue = "100") String max) {

		int minNum;
		int maxNum;

		try {
			minNum = Integer.valueOf(min);
			maxNum = Integer.valueOf(max);
		} catch (NumberFormatException e) {
			return new ResponseEntity<String>("Please ensure you enter a numeric value for both Minimum and Maximum",
					HttpStatus.BAD_REQUEST);
		}
		// ensure maximum is never less than minimum
		if (minNum >= maxNum) {
			return new ResponseEntity<String>("Please ensure the Maximum value is larger than the Minimum value",
					HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(Integer.toString(getRandomNumberWithRange(minNum, maxNum)), HttpStatus.OK);
	}

	// Random generator function
	private int getRandomNumberWithRange(int min, int max) {
		// random number generator between two numbers
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
