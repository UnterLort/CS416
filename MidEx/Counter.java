/**
 * Counter Midterm Exam.
 * 
 * @author Kyle Stewart
 * @version 1
 */

class Counter implements Freezable {
    private int count;
    private int incrementAmount;
    private boolean frozen;

    /**
     * 
     * @param startCount      starting count value
     * @param incrementAmount amount to increment by
     */
    Counter(int startCount, int incrementAmount) {
        this.count = startCount;
        this.incrementAmount = incrementAmount;
        this.frozen = false;
    }

    /**
     * 
     * @return current count value
     */
    public int getCount() {
        return count;
    }

    /**
     * 
     * Increment count by specified amount, if counter is not frozen.
     */
    public void increment() {
        if (!frozen) {
            count += incrementAmount;
        }
    }

    /**
     * 
     * Freeze counter to prevent further changes to count.
     */
    @Override
    public void freeze() {
        frozen = true;
    }

    /**
     * 
     * Unfreeze counter to allow changes to count.
     */
    @Override
    public void unfreeze() {
        frozen = false;
    }
}