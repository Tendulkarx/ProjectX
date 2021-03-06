package com.rest.project.controllers;

import java.lang.StringBuilder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReverseStringController {

	@RequestMapping("/reversedWord")
	public StringBuilder reversedWord(@RequestParam(value = "word", defaultValue = "MAP SEY") String word) {
		return reversed(word);
	}

	//Reverse a given string
	private StringBuilder reversed(String word) {
	
		StringBuilder builder = new StringBuilder();
		builder.append(word);
		builder.reverse();
		return builder;
	}
}