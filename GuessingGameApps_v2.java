package com.coderscampus;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

//Class GuessingGameApps
public class GuessingGameApps {
	// Constants
	static final int Min = 1;
	static final int Max = 101;
	static final int MAX_TRY = 5;

	public static void main(String[] args) {

		int numberInput;
		int numberGuess;
		int theRandomNumber;

		theRandomNumber = generateRandomNumber(Min, Max);
		System.out.println("");	
		numberInput = userInput();
		//System.out.println("");
		numberGuess = validateNumber(numberInput);
		//System.out.println("");

		// Loop through five tries
		for (int i = 1; i <= MAX_TRY; i++) {
			displayLowHighMessage(theRandomNumber, numberGuess, i);
			//System.out.println("");
			numberInput = userInput();
			//System.out.println("");
			numberGuess = validateNumber(numberInput);
			//System.out.println("");		
		}
		

	} // end main

	/**************************************************************************/
	/****************************** Declare methods ****************************/
	/**************************************************************************/

	// displayMesage method
	private static void displayLowHighMessage(int randomNumber, int numberGuess, int number) {
		//System.out.println(" ");
		if ((number == MAX_TRY) && !(numberGuess == randomNumber)) {
			if (numberGuess < randomNumber) {
				System.out.println(" ");
				pickHighNumber();
			} else if (numberGuess > randomNumber) {
				System.out.println(" ");
				pickLowNumber();
			}
			
			System.out.println("You lose!");
			System.out.println(" ");
			//System.out.println(" ");
			System.out.println("The number to guess was: " + randomNumber);
			System.exit(0);
		} else if (number <= MAX_TRY) {
			if (numberGuess == randomNumber) {
				System.out.println(" ");
				System.out.println("You win!");
				System.out.println(" ");
				//System.out.println("The number to guess was: " + randomNumber);
				System.out.println(" ");
				System.exit(0);
			} else if (numberGuess < randomNumber) {
				System.out.println(" ");
				pickHighNumber();
			} else if (numberGuess > randomNumber) {
				System.out.println(" ");
				pickLowNumber();
			}
		}

	}

	public static void pickLowNumber() {
		//System.out.println(" ");
		System.out.println("Please pick a lower number");
		System.out.println(" ");
	}

	public static void pickHighNumber() {
		//System.out.println(" ");
		System.out.println("Please pick a higher number");
		System.out.println(" ");
	}

	// validateNumber method
	private static int validateNumber(int number) {
		boolean answer = true;
		while (answer) {
			if (number > 0 && number <= 100) {
				answer = false;
			} else {
				System.out.println("");
				System.out.println("Your guess is not between 1 and " + "100, please try again");
				System.out.println("");
				number = userInput();
			}
		}
		return number;
	}

	// generateRandomNumber method
	private static int generateRandomNumber(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}

	// userInput method
	private static int userInput() {
		//System.out.println("");
		System.out.print("Pick a number between 1 and 100: ");
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		return number;
	}
} // End of the Class GuessingGameApps
