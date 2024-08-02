import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static int score = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;
        
        do {
            playGame(scanner);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("yes"));
        
        System.out.println("Your final score is: " + score);
        scanner.close();
    }
    
    private static void playGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;
        
        System.out.println("Guess the number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts.");
        
        while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            
            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                score++;
                hasGuessedCorrectly = true;
            } else if (userGuess > numberToGuess) {
                System.out.println("Your guess is too high.");
            } else {
                System.out.println("Your guess is too low.");
            }
        }
        
        if (!hasGuessedCorrectly) {
            System.out.println("Sorry! You've used all your attempts. The number was " + numberToGuess);
        }
    }
}
