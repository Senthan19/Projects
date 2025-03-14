import java.util.*;

public class GuessNumber {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Random random = new Random();

    System.out.println("Welcome to the Number Guessing Game!");
    boolean playAgain = true;
    int totalAttempts = 0;
    int totalRounds = 0;

    while (playAgain) {
        totalRounds++;
        int numberToGuess = random.nextInt(100) + 1; 
        int attempts = 0;
        boolean guessedCorrectly = false;
        
        System.out.println("\nRound " + totalRounds + ": Guess a number between 1 and 100");

        while (!guessedCorrectly) {
            System.out.print("Enter your guess: ");
            
            int userGuess = sc.nextInt();
            attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try a higher number.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    System.out.println("Congratulations! You guessed it right in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    guessedCorrectly = true;
                }
            } 
        	sc.nextLine();
	        System.out.print("Do you want to play again? (yes/no): ");
	        String response = sc.nextLine().trim().toLowerCase();
	        playAgain = response.equals("yes");
        }
    	
    System.out.println("\nGame Over!");
    System.out.println("You played " + totalRounds + " rounds with a total of " + totalAttempts + " attempts.");
     
    sc.close();
    }
        
}

