/**
 * 
 * @author Kyle Stewart
 * @version 2
 * Represnts a stack data structure.
 */
public class Stack {
    private int[] stack;
    private int index;

    /**
     * 
     * Constructor for the Stack class.
     * Sets the index to -1 to represent an empty stack.
     */
    public Stack() {
        stack = new int[10];
        index = -1;
    }

    /**
     * 
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return index == -1;
    }

    /**
     * 
     * @param value The value to be pushed to the stack.
     * @return true if the value was added successfully, false otherwise.
     */
    public boolean push(int value) {
        if (index < stack.length - 1) {
            stack[++index] = value;
            return true;
        }
        return false;
    }

    /**
     * 
     * @return The popped value.
     * @throws IllegalStateException If the stack is empty.
     */
    public int pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[index--];
    }

    /**
     * 
     * @return The next value from the stack.
     * @throws IllegalStateException If the stack is empty.
     */
    public int peek() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[index];
    }

    /**
     * 
     * @return The string representation of the stack.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = index; i >= 0; i--) {
            sb.append(stack[i]);
            if (i != 0) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}