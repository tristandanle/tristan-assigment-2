package com.coderscampus;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

//Class GuessingGameApps
public class GuessingGameApps_v2 {
	// Constants
	static final int Min = 1;
	static final int Max = 101;
	static final int MAX_TRY = 5;

	public static void main(String[] args) {

		int numberInput;
		int numberGuess;
		int theRandomNumber;

		theRandomNumber = generateRandomNumber(Min, Max);
		numberInput = userInput();
		numberGuess = validateNumber(numberInput);

		// Loop through five tries
		for (int i = 1; i <= MAX_TRY; i++) {
			displayLowHighMessage(theRandomNumber, numberGuess, i);
			numberInput = userInput();
			numberGuess = validateNumber(numberInput);
		}
		

	} // end main

	/**************************************************************************/
	/****************************** Declare methods ****************************/
	/**************************************************************************/

	// displayMesage method
	private static void displayLowHighMessage(int randomNumber, int numberGuess, int number) {
		if ((number == MAX_TRY) && !(numberGuess == randomNumber)) {
			System.out.println("You lose!");
			System.out.println(" ");
			System.out.println("The number to guess was: " + numberGuess);
			System.exit(0);
			
			System.exit(0);
		} else if (number <= MAX_TRY) {
			if (numberGuess == randomNumber) {
				System.out.println("You win!");
				System.out.println(" ");
				System.out.println("The number to guess was: " + numberGuess);
				System.exit(0);
			} else if (numberGuess < randomNumber) {
				System.out.println("Please pick a higher number");
				System.out.println(" ");
			} else if (numberGuess > randomNumber) {
				System.out.println("Please pick a lower number");
				System.out.println(" ");
			}
		}

	}

	// validateNumber method
	private static int validateNumber(int number) {
		boolean answer = true;
		while (answer) {
			if (number > 0 && number <= 100) {
				answer = false;
			} else {
				System.out.println("Your guess is not between 1 and " + "100, please try again");
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
		System.out.println("Pick a number between 1 and 100: ");
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		return number;
	}
} // End of the Class GuessingGameApps
