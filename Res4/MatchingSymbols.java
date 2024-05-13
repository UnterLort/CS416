import java.util.Scanner;

/**
 * 
 * A class for checking the validity of symbol matchings in a string.
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class MatchingSymbols {

    private static final String OPEN_SYMBOLS = "([{<";
    private static final String CLOSE_SYMBOLS = ")}]>";

    /**
     * 
     * Check if the symbol matching in the given string is valid.
     * 
     * @param arg the string to check
     * @return true if the symbol matching is valid, false otherwise
     */
    private static boolean isValid(String arg) {

        Stack<Character> stack = new Stack<>();

        for (char c : arg.toCharArray()) {
            if (OPEN_SYMBOLS.indexOf(c) != -1) {
                stack.push(c);
            } else if (CLOSE_SYMBOLS.indexOf(c) != -1) {
                if (stack.size() == 0) {
                    return false;
                }
                char opposite = ' ';
                switch (c) {
                    case ')':
                        opposite = '(';
                        break;
                    case '}':
                        opposite = '{';
                        break;
                    case ']':
                        opposite = '[';
                        break;
                    case '>':
                        opposite = '<';
                        break;
                }

                if (stack.peek() != opposite) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.size() == 0;
    }

    /**
     * 
     * Main method to check the validity of symbol matchings in a string.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (isValid(input)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

        scanner.close();

    }
}