/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class InsertionSort extends Sort {

    /**
     * @param fileName name of the file to be sorted
     */
    public InsertionSort(String fileName) {
        super(fileName);
    }

    @Override
    public void sort() {
        int n = samples.size();
        for (int i = 1; i < n; ++i) {
            Sample key = samples.get(i);
            int j = i - 1;

            /*
             * Move elements of samples[0..i-1], that are greater than key, to one position
             * ahead
             * of their current position
             */
            while (j >= 0 && samples.get(j).measurement < key.measurement) {
                samples.set(j + 1, samples.get(j));
                j = j - 1;
            }
            samples.set(j + 1, key);
        }
    }
}