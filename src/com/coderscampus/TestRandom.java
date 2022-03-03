package com.coderscampus;

import java.util.Random;

public class TestRandom {

	public static void main(String[] args) {
	    
	        // what is our range?
	        int max = 100;
	        int min = 1;
	      // create instance of Random class
	        Random randomNum = new Random();
	        int showMe = min + randomNum.nextInt(max);
	        System.out.println(showMe);
	      }
	

}
