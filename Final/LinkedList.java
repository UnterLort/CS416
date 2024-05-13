/**
 * 
 * LinkedList represent doubly linked list data structure.
 * Allows adding and removing elements from both head and tail of list.
 * 
 * @author Kyle Stewart
 * @version 1
 * @param <T> type of element stored in linked list
 */
public class LinkedList<T> {

    Node head;
    Node tail;

    /**
     * 
     * Represent node in linked list.
     */
    public class Node { // inner class
        T data;
        Node next;
        Node prev;

        /**
         * 
         * Construct new node with data.
         * 
         * @param data to be stored in node
         */
        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * 
     * Add new node with the data to the head of list.
     * 
     * @param data to be added to the head of list
     */
    public void addHead(T data) {
        Node n = new Node(data);

        if (head == null) { // empty list
            head = n;
            tail = n;
            return;
        }
        head.prev = n;
        n.next = head;

        head = n;
    }

    /**
     * 
     * Add new node with the data to the tail of list.
     * 
     * @param data to be added to the tail of list
     */
    public void addTail(T data) {
        Node n = new Node(data);
        if (tail == null) { // empty list
            head = n;
            tail = n;
            return;
        }
        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    /**
     * 
     * Remove and return data stored in node at head of list.
     * 
     * @return data stored in node at head of list
     */
    public T remHead() {
        Node ret = head;

        if (head == null) {
            return null;
        }
        if (head == tail) { // empty after removing tail
            head = null;
            tail = null;
            return ret.data;
        }
        head = head.next;
        head.prev = null;
        return ret.data;
    }

    /**
     * 
     * Remove and return data stored in node at tail of list.
     * 
     * @return data stored in node at tail of list
     */
    public T remTail() {
        Node ret = tail;

        if (tail == null) {
            return null;
        }
        if (head == tail) { // empty after removing tail
            head = null;
            tail = null;
            return ret.data;
        }

        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }

        return ret.data;
    }

    /**
     *
     * @return data stored in node at head of list
     */
    public T getHead() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    /**
     *
     * @return data stored in node at tail of list
     */
    public T getTail() {
        if (tail == null) {
            return null;
        }
        return tail.data;
    }

    /**
     *
     * @return string representation of linked list
     */
    public String toString() {
        String ret = "";

        Node curr = head;
        while (curr != null) {
            ret += curr.data + " ";
            curr = curr.next;
        }

        return ret;
    }
}