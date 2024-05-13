/**
 * Freezable Midterm Exam.
 * 
 * @author Kyle Stewart
 * @version 1
 */
public interface Freezable {

    /**
     * 
     * Freeze object, preventing further changes to its state.
     */
    void freeze();

    /**
     * 
     * Unfreeze object, allowing changes to its state.
     */
    void unfreeze();
}