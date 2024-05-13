import java.util.ArrayList;

/**
 *
 * @author Kyle Stewart
 * @version 2
 */
public class LabStack {
    /**
     * 
     * @param st The stack to pop items from.
     * @param n The number of items to pop.
     * @return An ArrayList containing the popped items.
     */
    public static ArrayList<Integer> popN(Stack st, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(st.pop());
        }
        return result;
    }

    /**
     *
     * @param st The stack to pop items from.
     * @return An ArrayList containing all the popped items.
     */
    public static ArrayList<Integer> popAll(Stack st) {
        ArrayList<Integer> result = new ArrayList<>();
        while (!st.isEmpty()) {
            result.add(st.pop());
        }
        return result;
    }

    /**
     *
     * @param arr The array to be reversed.
     * @return A new array with the values from arr reversed.
     */
    public static int[] reverse(int[] arr) {
        Stack stack = new Stack();
        for (int value : arr) {
            stack.push(value);
        }
        int[] reversedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = stack.pop();
        }
        return reversedArr;
    }
}