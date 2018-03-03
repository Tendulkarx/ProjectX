package com.rest.project.ProjectX;

public class RandomNum {
	
	private final long id;
	private final int randomNumber;
    
	 public RandomNum(long id, int randomNumber) {
	        this.id = id;
	        this.randomNumber = randomNumber;
	    }
	
	public long getId() {
		return id;
	}
	
	public int getRandomNumber() {
		return randomNumber;
	}
}
