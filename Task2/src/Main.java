import java.util.Scanner;
import java.util.Random;
public class Main {
	
	

	public static void main(String[] args) {
		
		//Making the scanner object
		Scanner obj = new Scanner(System.in);
		
		//Making random object and called it random
		Random random = new Random();
		//Setting the seed, so that it will be different everytime the program is executed
		random.setSeed(System.currentTimeMillis());
		
		//Initializing the target number produced by the computer with bound ranging from 1-100
		int targetNumber = random.nextInt(100)+1;
		
		//Initializing the guess from the user and guess count to count how many time the user has guessed
		int guess = 0;
		int guessCount = 0;
		
		
		//This while loop will continue until the program break
		while (true) {
			//Increment guessCount everytime the looping start
			guessCount++;
			
			System.out.print("Enter a number between 1 and 100 (-1 is to give up): ");
			guess = obj.nextInt();
			
			//This two branch of if-else will the check whether the guess is lower or higher than the target number
			if (guess > targetNumber && guess != -1) {
				System.out.println("Target number is lower than your guess number!");
			} 
			else if (guess < targetNumber && guess != -1){
				System.out.println("Target number is higher than your guess number!");
			}
			
			//If the user enter -1 as the input, the program will reduced the guessCount by one because the -1 is not counted as a guess
			else if (guess == -1){
				guessCount -= 1;
				System.out.print("\n");
				System.out.println("Fail to guess the target number!");
				System.out.printf("Guess Count: %d\n", guessCount);
				System.out.println("Oops! Computer wins!");
				break;
			}
			//This if for the winner of loser
			else {
				System.out.print("\n");
				System.out.println("Correct Number!");
				System.out.printf("Guess Count: %d\n", guessCount);
				//The condition if the guess count is under 7
				if (guessCount <= 7) {
					System.out.println("Congratulations! Player wins!");
					break;
				}
				else {
					System.out.println("Oops! Computer wins!");
					break;
				}
			}
			
		}

	}

}
