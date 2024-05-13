/**
 * 
 * Represent generic queue data structure implemented using linked list.
 * 
 * @author Kyle Stewart
 * @version 1
 * @param <T> type of elements held in queue
 */
public class Queue<T> {
    private LinkedList<T> list;

    /**
     * 
     * Construct an empty queue.
     */
    public Queue() {
        list = new LinkedList<>();
    }

    /**
     * 
     * Add specified element to end of queue.
     *
     * @param item element to be added to queue
     */
    public void add(T item) {
        list.addTail(item);
    }

    /**
     *
     * @return head of queue
     */
    public T remove() {
        return list.remHead();
    }

    /**
     *
     * @return the linked list representing the queue
     */
    public LinkedList<T> getList() {
        return list;
    }
}