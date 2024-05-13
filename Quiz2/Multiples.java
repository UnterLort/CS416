/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class Multiples implements Sequence {

    private int num;
    private int counter;

    /**
     * 
     * @param num the number whose multiples are to be generated
     */
    public Multiples(int num) {
        this.num = num;
        this.counter = 1;
    }

    /**
     * 
     * @return the next multiple in the sequence
     */
    public int nextVal() {
        int result = num * counter;
        counter++;
        return result;
    }

    /**
     * 
     * Resets the counter to 1, restarting the sequence from the beginning.
     */
    public void reset() {
        counter = 1;
    }

}