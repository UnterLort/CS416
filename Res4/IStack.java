/**
 * 
 * @author Kyle Stewart
 * @version 1
 * @param <T> is the T parameter. It represents the type of data that will be
 *            stored
 */
public interface IStack<T> {

    /**
     * 
     * Add the T parameter to the top of the stack.
     * 
     * @param val the T value.
     */
    void push(T val);

    /**
     * 
     * Remove and return the top element of the stack.
     * Throw an EmptyStackException if there are 0 elements.
     * 
     * @return the pop value
     */
    T pop();

    /**
     * 
     * Return the top element of the stack.
     * Throw an EmptyStackException if there are 0 elements.
     * 
     * @return the peek value
     */
    T peek();

    /**
     * 
     * Return the current number of elements stored in the stack.
     * 
     * @return the size value.
     */
    int size();
}