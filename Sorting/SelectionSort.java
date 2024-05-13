/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class SelectionSort extends Sort {

    /**
     * @param fileName name of the file to be sorted
     */
    public SelectionSort(String fileName) {
        super(fileName);
    }

    @Override
    public void sort() {
        int n = samples.size();
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i; // Renamed variable to adhere to naming convention
            for (int j = i + 1; j < n; j++) {
                if (samples.get(j).measurement > samples.get(maxIndex).measurement) {
                    maxIndex = j;
                }
            }
            // Swap the found maximum element with the first element
            Sample temp = samples.get(maxIndex);
            samples.set(maxIndex, samples.get(i));
            samples.set(i, temp);
        }
    }
}