/**
 * 
 * @author Kyle Stewart
 * @version 2
 */
public class BubbleSort extends Sort {

    /**
     * 
     * @param fileName name of the file to be sorted
     */
    public BubbleSort(String fileName) {
        super(fileName);
    }

    @Override
    public void sort() {
        int n = samples.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (samples.get(j).measurement < samples.get(j + 1).measurement) {
                    // Swap elements
                    Sample temp = samples.get(j);
                    samples.set(j, samples.get(j + 1));
                    samples.set(j + 1, temp);
                }
            }
        }
    }
}