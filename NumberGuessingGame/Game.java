package NumberGuessingGame;

import java.util.Scanner;

public class Game {

    public static void numberGuessing() {
        // Scanner object
        Scanner scan = new Scanner(System.in);

        // Generate number from 1 to 100
        int number = 1 + (int) (100 * Math.random());

        // Initialize number of attempts
        int attempts = 3;

        // Game Introduction
        System.out.println("Choose the number between 1 to 100");
        System.out.println("You have only " + attempts + " attempts to guess the number");

        // Now Loop through attempts
        for (int i = 1; i <= attempts; i++) {

            // Enter the number to guess
            System.out.println("Enter the number to guess: ");
            // Handling non-integer input
            if (!scan.hasNextInt()) {
                System.out.println("Invaild input. Please enter a number.");
                scan.next();
                i--;
                continue;
            }
            int guess = scan.nextInt();

            // Check the guessed number
            if (guess == number) {
                System.out.println("Congratulations! You have guess correct number ");
                scan.close();
                return;
            } else if (guess > number) {
                System.out.println("Guessed number is greater than number.");
            } else {
                System.out.println("Guessed number is smaller than number.");
            }
        }

        // Attempts details
        System.out.println("Number of attempts over. Please try again.");
        System.out.println("The number was: " + number);

        scan.close();
    }

    public static void main(String[] args) {
        numberGuessing();
    }
}
