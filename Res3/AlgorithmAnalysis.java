/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class AlgorithmAnalysis {

    /**
     * 
     * Calculates the sum of elements in a subarray.
     *
     * @param arr   The input array.
     * @param start The starting index of the subarray.
     * @param end   The ending index of the subarray.
     * @return The sum of elements in the subarray.
     */
    public static int sum_sub_array(int[] arr, int[] start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) { //
            sum += arr[i];
        }

        return sum;

    }

    /**
     * 
     * Algorithm with a time complexity of O(n^3) to find the maximum sum of a
     * subarray.
     *
     * @param arr The input array.
     * @return The maximum sum of a subarray.
     */
    public static int alg1(int[] arr) {

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= arr.length; i++) {

            for (int j = 0; j + 1 <= arr.length; j++) {
                int sum = sum_sub_array(arr, j, j + 1);
                if (sum > max) {
                    max = sum;
                }
            }

        }

        return max;
    }

    /**
     * 
     * Algorithm with a time complexity of O(n^2) to find the maximum sum of a
     * subarray.
     *
     * @param arr The input array.
     * @return The maximum sum of a subarray.
     */
    public static int alg2(int[] arr) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.length; i++) {
            int prevSum = 0;
            for (int j = i; j < arr.length; j++) {
                prevSum += arr[j];
                if (prevSum > max) {
                    max = prevSum;
                }
            }

        }

        return max;
    }

    /**
     * 
     * Algorithm with a time complexity of O(n^2) to find the maximum sum of a
     * subarray with a specific condition.
     *
     * @param arr The input array.
     * @return The maximum sum of a subarray with a specific condition.
     */
    public static int alg3(int[] arr) {
        int max = 0;

        for (int i = 0; i <= arr.length; i++) {
            int prevSum = 0;
            for (int j = i; j < arr.length; j++) {
                prevSum += arr[j];
                if (prevSum < 0) {
                    i = j;
                    break;
                }

                if (prevSum > max) {
                    max = prevSum;
                }
            }

        }

        return max;
    }

    /**
     * 
     * Main method to test the algorithms.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        int[] test1 = {-1, -12, -3, 14, -4, 3};
        int test1Expected = 23;
        System.out.println("Expected: " + test1Expected);
        System.out.println("Actual Alg1: " + alg1(test1));
        System.out.println("Actual Alg2: " + alg2(test1));
        System.out.println("Actual Alg3: " + alg3(test1));
        assert test1Expected == alg1(test1);
        assert test1Expected == alg2(test1);
        assert test1Expected == alg3(test1);

        int[] test2 = {2, -3, 5, -1, 0, 7};
        int test2Expected = 11;
        System.out.println("Expected: " + test2Expected);
        System.out.println("Actual Alg1: " + alg1(test2));
        System.out.println("Actual Alg2: " + alg2(test2));
        System.out.println("Actual Alg3: " + alg3(test2));
        assert test1Expected == alg1(test2);
        assert test1Expected == alg2(test2);
        assert test1Expected == alg3(test2);

    }

}