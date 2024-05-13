import java.util.Scanner;

/**
 * 
 * Program lists the steps in the solution of the TowerOfHanoi
 * problem. The number of disks to be moved is specified by the user.
 * Warning: The number of moves grows very quickly with the number of
 * disks!
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class TowersOfHanoi {

    /**
     * 
     * @param args Command line argument
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N;
        // The number of disks in the original stack,
        // as specified by the user

        System.out.println("This program will list the steps in the solution of");
        System.out.println("the Towers of Hanoi problem. You can specify the");
        System.out.println("number of disks to be moved. Try it for small numbers");
        System.out.println("of disks, like 1, 2, 3, adnd 4 ");
        System.out.println();
        System.out.println("How many disks are to be moved from Stack 0 to Stack 1?");
        System.out.println();
        System.out.print("? ");

        N = in.nextInt();

        System.out.println();
        System.out.println();

        towersOfHanoi(N, 0, 1, 2); // Print solution

        System.out.println("Done");
    }

    /**
     * 
     * Solve the problem of moving the number of disks specified
     * by the first parameter from the stack specified by the
     * second parameter to the stack specified by the third parameter.
     * Stack specified by the fourth parameter is available for use
     * as a spare. Stacks are specified by number: 0, 1, or 2.
     * 
     * @param disks Number of disks remaining on the source tower
     * @param from  Tower Source Tower
     * @param to    Tower Destination Tower
     * @param spare Tower Auxiliary Tower
     */
    static void towerOfHanoi(int disks, int from, int to, int spare) {

        if (disks == 1) {
            // System.out.printf("Move 1 disk from stack %d to stack %d%n", from, to);
        } else {

            // move n-1 disk "off of the biggest"
            towerOfHanoi(disks - 1, from, spare, to);

            // move the biggest to the correct stack
            // System.out.printf("Move 1 disk from stack %d to stack %d%n, from, to)");

            // move n01 disks from space to correct stack
            towerOfHanoi(disks - 1, spare, to, from);
        }

        // Recursive case(s)
    }
}