/**
 * 
 * Represent a generic stack data structure using linked list.
 * 
 * @author Kyle Stewart
 * @version 1
 * @param <T> type of elements held in stack
 */
public class Stack<T> {
    private LinkedList<T> list;

    /**
     * 
     * Construct an empty stack.
     */
    public Stack() {
        list = new LinkedList<>();
    }

    /**
     * 
     * Push element onto top of stack.
     *
     * @param item element to be pushed onto stack
     */
    public void push(T item) {
        list.addHead(item);
    }

    /**
     *
     * @return element at top of stack
     */
    public T pop() {
        return list.remHead();
    }

    /**
     *
     * @return linked list representing stack
     */
    public LinkedList<T> getList() {
        return list;
    }
}