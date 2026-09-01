import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

       
        System.out.println("       NUMBER GUESSING GAME");
      
        do {
            // Generate random number between 1 and 100
            int number = random.nextInt(100) + 1;

            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            // Guessing loop
            for (int attempt = 1; attempt <= maxAttempts; attempt++) {

                System.out.print("\nAttempt " + attempt + "/" + maxAttempts
                        + " - Enter your guess: ");

                int guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    System.out.println("You guessed it in " + attempt + " attempts!");

                    guessedCorrectly = true;
                    score++;
                    break;

                } else if (guess > number) {
                    System.out.println("Too high! Try a smaller number.");

                } else {
                    System.out.println("Too low! Try a larger number.");
                }
            }

            // If user failed all attempts
            if (!guessedCorrectly) {
                System.out.println("\nSorry! You used all your attempts.");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("\nYour current score: " + score);

            // Ask whether to play another round
            System.out.print("\nDo you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("          GAME OVER");
        System.out.println("Final Score: " + score);
        System.out.println("Thanks for playing!");

        sc.close();
    }
}