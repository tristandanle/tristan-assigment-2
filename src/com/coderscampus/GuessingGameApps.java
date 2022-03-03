package com.coderscampus;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

//Class GuessingGameApps
public class GuessingGameApps {

	// Main method
	public static void main(String[] args) {

		// Constants
		int Min = 1;
		int Max = 101;
		int MAX_TRY = 5;
		//Variables
		int numberInput;
		int numberGuess;
		int theRandomNumber;

		theRandomNumber = generateRandomNumber(Min, Max);
		numberInput = userInput();
		numberGuess = validateNumber(numberInput);

		// Loop through five tries
		for (int i = 1; i < MAX_TRY; i++) {
			if (theRandomNumber == numberGuess) {
				System.out.println("You win!");
				break;
			}
			displayLowHighMessage(theRandomNumber, numberGuess);
			numberInput = userInput();
			numberGuess = validateNumber(numberInput);
			if (i == MAX_TRY - 1) {
				System.out.println("You lose!");
			}
		}
		System.out.println("The number to guess was: " + numberGuess);

	} // end main
	
	
    /**************************************************************************/
    /****************************** Declare methods****************************/
    /**************************************************************************/
   
	// displayMesage method
	private static void displayLowHighMessage(int randomNumber, int number) {
		if (number < randomNumber) {
			System.out.println("Please pick a higher number");
		} else if (number > randomNumber) {
			System.out.println("Please pick a lower number");
		} else {
			System.out.println("You win");
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
		// Random random = new Random();
		// System.out.println("random number in:" + random.nextInt(max));
		// int randomInt = ThreadLocalRandom.current().nextInt(1, 51);
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
