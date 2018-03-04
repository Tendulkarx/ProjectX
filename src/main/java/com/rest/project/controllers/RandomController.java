package com.rest.project.controllers;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.project.exceptions.RandomNumberBadRequestException;

@RestController
public class RandomController {

	private int minNum;
	private int maxNum; 
	
	@RequestMapping("/randomNum")
	public ResponseEntity<String> randomNum(@RequestParam(value = "min", defaultValue = "0") String min,
			@RequestParam(value = "max", defaultValue = "100") String max) {
		
		try {
			requestValidation(min, max);
		} catch (RandomNumberBadRequestException e) {
			return new ResponseEntity<String>(e.getMessage(),
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
	
	private void requestValidation(String min, String max) throws RandomNumberBadRequestException{
		try {
			minNum = Integer.valueOf(min);
			maxNum = Integer.valueOf(max);
		}catch (NumberFormatException e) {
			throw new RandomNumberBadRequestException("Please ensure you enter a numeric value for both Minimum and Maximum");
		}
		
		if (minNum >= maxNum) {
			throw new RandomNumberBadRequestException("Please ensure the Maximum value is larger than the Minimum value");
		}
	}
}
