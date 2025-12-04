import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;    // total rounds won
        String playAgain;

        do {
            int number = rand.nextInt(100) + 1;  // generates number between 1-100
            int attempts = 0;
            int maxAttempts = 7;  // limit attempts
            boolean guessed = false;

            System.out.println("🎯 NUMBER GUESSING GAME");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!\n");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                    guessed = true;
                    score++;   // increase score if user wins round
                    break;
                } else if (guess > number) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
            }

            if (!guessed) {
                System.out.println("\n❌ You ran out of attempts!");
                System.out.println("The correct number was: " + number);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n🏆 Game Over! Your Final Score (Rounds Won): " + score);
        System.out.println("Thanks for playing ❤️");

        sc.close();
    }
}