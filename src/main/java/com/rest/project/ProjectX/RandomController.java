package com.rest.project.ProjectX;

import java.util.Random;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {
	

    @RequestMapping("/randomNum")
    public int randomNum(@RequestParam(value="min", defaultValue="0") String min, 
    		@RequestParam(value="max", defaultValue="100") String max) {
    		int minNum = Integer.valueOf(min);
    		int maxNum = Integer.valueOf(max);
    		
    		return getRandomNumberWithRange(minNum, maxNum);
    }
	

	private int getRandomNumberWithRange(int min, int max) {
		// ensure maximum is never less than minimum
		if (min >= max) 
			throw new IllegalArgumentException("The Max number must be greater than the Min number");
		
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
