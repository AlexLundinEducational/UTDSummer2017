package exercises;

import java.util.Scanner;

public class Ex3_15 {

	

	public static void main(String[] args) {
		    // Generate a lottery
		    int lottery = (int)(Math.random() * 1000);

		    // Prompt the user to enter a guess
		    Scanner input = new Scanner(System.in);
		    System.out.print("Enter your lottery pick, 3 integers, (one digit at a time): ");
		    int guess = input.nextInt();
		    
		    // Get digits from lottery
		    int lotteryDigit1 = lottery / 100;
		    int lotteryDigit2 = lottery % 100;
		    int lotteryDigit3 = lottery % 10;

		    // Get digits from guess
		    int guessDigit1 = guess / 100;
		    int guessDigit2 = guess % 100;
		    guessDigit2 = guessDigit2 / 10;
		    int guessDigit3 = guess % 10;

		    System.out.println("The lottery number is " + guessDigit2);


	  }
	


}
