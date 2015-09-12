package highlow;
import java.util.Random;
import assignmentframework.Interaction;

/**
 * Created by Fabian Gillholm on 2015-09-04.
 */
public class HighLow {
    public static void main(String[] args) {
        // Get a random secret number between 1 and 100
        Random random = new Random();
        int secret = random.nextInt(100) + 1;
        System.out.println("The secret number is between 1 and 100. See if you can guess it.");

        for(int guesses = 1; guesses <= 10; guesses++) {
            int guess = Interaction.getPositiveInteger("Guess " + guesses + ": ");

            // If the user guessed correctly, tell them something nice and exit the program
            if(guess == secret) {
                System.out.println("Correct after only " + guesses + " guesses - Brilliant!");
                System.exit(0);
            }
            // If the user guessed wrong, give them a hint
            if(guess < secret) {
                System.out.println("Hint: higher");
            }
            else {
                System.out.println("Hint: lower");
            }
        }

        // If the user is out of guesses, present the correct answer in a polite message
        System.out.println("YOU SUCK! The correct answer was " + secret);
    }
}
