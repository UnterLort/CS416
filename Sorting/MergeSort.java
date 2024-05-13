import java.util.ArrayList;

/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class MergeSort extends Sort {

    /**
     * @param fileName name of the file to be sorted
     */
    public MergeSort(String fileName) {
        super(fileName);
    }

    @Override
    public void sort() {
        mergeSort(samples, 0, samples.size() - 1);
    }

    /**
     * @param arr array to be sorted
     * @param l   left index
     * @param m   middle index
     * @param r   right index
     */
    private void merge(ArrayList<Sample> arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temporary arrays */
        ArrayList<Sample> leftSubArray = new ArrayList<Sample>(n1);
        ArrayList<Sample> rightSubArray = new ArrayList<Sample>(n2);

        /* Copy data to temporary arrays */
        for (int i = 0; i < n1; ++i) {
            leftSubArray.add(arr.get(l + i));
        }
        for (int j = 0; j < n2; ++j) {
            rightSubArray.add(arr.get(m + 1 + j));
        }

        /* Merge the temporary arrays */

        // Initial indexes of first and second subarrays
        int i = 0;
        int j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (leftSubArray.get(i).measurement >= rightSubArray.get(j).measurement) {
                arr.set(k, leftSubArray.get(i));
                i++;
            } else {
                arr.set(k, rightSubArray.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of leftSubArray[] if any */
        while (i < n1) {
            arr.set(k, leftSubArray.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of rightSubArray[] if any */
        while (j < n2) {
            arr.set(k, rightSubArray.get(j));
            j++;
            k++;
        }
    }

    /**
     * @param arr array to be sorted
     * @param l   left index
     * @param r   right index
     */
    private void mergeSort(ArrayList<Sample> arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}