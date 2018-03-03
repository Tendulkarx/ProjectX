package com.rest.project.ProjectX;

import java.lang.StringBuilder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReverseStringController {

	@RequestMapping("/reversedWord")
	public StringBuilder reversedWord(@RequestParam(value = "word", defaultValue = "MAP SEY") String word) {
		String input = String.valueOf(word);
		return reversed(input);
	}

	//Reverse a given string
	private StringBuilder reversed(String word) {
	
		StringBuilder builder = new StringBuilder();
		builder.append(word);
		builder.reverse();
		return builder;
	}
}