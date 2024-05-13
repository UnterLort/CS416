import java.util.EmptyStackException;

/**
 * 
 * A generic stack implementation.
 * 
 * @author Kyle Stewart
 * @version 1
 * @param <T> the type of elements in the stack
 */
public class Stack<T> implements IStack<T> {

    /**
     * 
     * The Node.
     */
    private class Node {

        T val;
        Node next;
    }

    private Node head;
    private int size;

    /**
     * 
     * Construct an empty stack.
     */
    public Stack() {
        head = null;
        size = 0;
    }

    /**
     * 
     * Push an element onto the top of the stack.
     *
     * @param val the element to be pushed
     */
    public void push(T val) {
        Node n = new Node();
        n.val = val;
        n.next = head;
        head = n;
        size++;
    }

    /**
     * 
     * Remove and return the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Node n = head;
        head = head.next;
        size--;
        return n.val;
    }

    /**
     * 
     * Return the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return head.val;
    }

    /**
     * 
     * Return the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    public int size() {
        return size;
    }

    /**
     * 
     * Main method to test the Stack class.
     *
     * @param args The Command Line Argument
     */
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        assert s.peek() == 1;
        assert s.size() == 1;

        s.push(1);
        s.push(2);

        assert s.peek() == 2;
        assert s.size() == 3;

        assert s.pop() == 2;
        assert s.pop() == 1;
        assert s.pop() == 1;
        assert s.size() == 0;

        try {
            s.peek();
        } catch (EmptyStackException e) {
            System.out.println("Success");
        }
    }
}