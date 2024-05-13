import java.util.Scanner;

/**
 * @author Kyle Stewart
 * @version 1
 */

public class NGuesses {
    /**
     * @param args Commandline arguement
     */
    public static void main(String[] args) {
        int numGuesses = Integer.parseInt(args[0]);
        int pickedNumber = Integer.parseInt(args[1]);
        String prize = args[2];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numGuesses; i++) {
            System.out.println("Enter a guess:");
            int guess = scanner.nextInt();

            if (guess < pickedNumber) {
                System.out.println("Too low");
            } else if (guess > pickedNumber) {
                System.out.println("Too high");
            } else {
                System.out.println("That's the right number");
                System.out.println("Congratulations, you won a " + prize + "!");
                return;
            }
        }

        System.out.println("Sorry you didn't win, the number was " + pickedNumber);
    }
}