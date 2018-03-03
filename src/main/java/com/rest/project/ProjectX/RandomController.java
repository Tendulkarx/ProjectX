package com.rest.project.ProjectX;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {
	
	
	private static final int template = getRandomNumberWithRange(0, 100);
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/randomNum")
    public RandomNum randomNum(@RequestParam(value="number") int number) {
        return new RandomNum(counter.incrementAndGet(), template);
    }
	

	private static int getRandomNumberWithRange(int min, int max) {
		// ensure maximum is never less than minimum
		if (min >= max) throw new IllegalArgumentException("The maximum nmaber must be greater than the min Minimum");
		
		Random r = new Random();
		int randomNumber = r.nextInt((max - min) + 1) + min;
		return randomNumber;
	}
}
