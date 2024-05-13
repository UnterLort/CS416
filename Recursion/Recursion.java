/**
 * 
 * Class contains methods for recursive.
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class Recursion {

    /**
     * Checks if a string is a palindrome.
     *
     * @param input String to be checked.
     * @return True if the string is a palindrome.
     */
    public static boolean isPalindrome(String input) {
        if (input.length() <= 1) {
            return true;
        }
        if (input.charAt(0) != input.charAt(input.length() - 1)) {
            return false;
        }
        return isPalindrome(input.substring(1, input.length() - 1));
    }

    /**
     * 
     * Counts the occurrences of a letter in a string.
     *
     * @param input  String to be searched.
     * @param letter Letter to count occurrences.
     * @return Number of occurrences of the letter in the string.
     */
    public static int countLetter(String input, char letter) {
        if (input.length() == 0) {
            return 0;
        }
        if (input.charAt(0) != letter) {
            return countLetter(input.substring(1), letter);
        } else {
            return 1 + countLetter(input.substring(1), letter);
        }
    }

    /**
     * 
     * Find maximum value in array.
     *
     * @param list Array of integers to be searched.
     * @param n    Number of elements in the portion of the array being tested.
     * @return Maximum value in the array.
     */
    public static int maxValue(int[] list, int n) {
        if (n == 1) {
            return list[0];
        }
        return Math.max(list[n - 1], maxValue(list, n - 1));
    }

    /**
     * 
     * Main method to test the implemented functions.
     *
     * @param args The Command line arguments.
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome("abba")); // true
        System.out.println(isPalindrome("acttca")); // true
        System.out.println(isPalindrome("aca")); // true
        System.out.println(isPalindrome("a")); // true
        System.out.println(isPalindrome("hello")); // false

        System.out.println(countLetter("hello", 'l')); // 2

        int[] arr = {3, 7, 2, 8, 1};
        System.out.println(maxValue(arr, arr.length)); // 8
    }
}