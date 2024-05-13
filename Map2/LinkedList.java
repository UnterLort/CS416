import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * Class represents a singly linked list.
 * 
 * @author Kyle Stewart
 * @version 1
 * @param <T> Type of the elements in the list.
 */
public class LinkedList<T> extends List<T> implements Iterable<T> {

    public Node head;
    public Node tail;

    /**
     * 
     * Constructor for a new empty linked list.
     */
    public LinkedList() {
        head = null;
        tail = null;
    }

    /**
     * 
     * @return head
     */
    public Node getHead() {
        return head;
    }

    /**
     * 
     * @return tail
     */
    public Node getTail() {
        return tail;
    }

    /**
     * 
     * @return String
     */
    public String toString() {
        String r = "[";
        Node temp = head;
        while (temp != null) {
            if (temp.next == null) {
                r += temp.value;
            } else {
                r += temp.value + ", ";
            }

            temp = temp.next;
        }
        r += "]";
        return r;
    }

    /**
     * 
     * Appends the specified value to the end of this list.
     *
     * @param value T value to add
     * @return boolean True if the value is inserted
     */
    public boolean add(T value) {
        Node newNode = new Node(value);
        // System.out.println("ADD FUNCTION WAS CALLED");

        if (head == null) {
            head = newNode;
            head.prev = null;
            head.next = null;
            tail = newNode;
            tail.prev = null;
            tail.next = null;
            return true;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.value.equals(value)) {
                return false;
            }
            temp = temp.next;
        }
        newNode.prev = tail;
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;

        return true;
    }

    /**
     * 
     * Inserts the specified value at the specified position in this list.
     *
     * @param index Integer index at which to insert
     * @param value T value to insert
     */
    public void add(int index, T value) {
        Node newNode = new Node(value);
        boolean check = true;
        Node temp = head;
        int counter = 1;
        Node temp1 = new Node(null);

        // checks for duplicates + find out value at index
        while (temp != null) {
            if (temp.value.equals(value)) {
                check = false;
            }
            // node at index saved in temp1 wow this is really terrible what i doing
            if (counter == index) {
                temp1 = temp;
                temp1.next = temp.next;
            }
            counter++;
            temp = temp.next;
        }

        // if index is head
        if (head == null && index == 0) {
            head = newNode;
        } else if (check && index == 0) {
            newNode.next = head;
            head.prev = newNode;
            newNode.prev = null;
            head = newNode;
            // if index is tail
        } else if (check && temp1.next == null) {
            newNode.next = null;
            newNode.prev = temp1;
            tail.next = newNode;
            tail = newNode;
            // any other index
        } else if (check) {
            newNode.next = temp1.next;
            newNode.prev = temp1;
            newNode.next.prev = newNode;
            temp1.next = newNode;
        }
    }

    /**
     * 
     * Removes all of the elements from this list.
     */
    public void clear() {
        head = null;
        tail = null;
    }

    /**
     * 
     * Returns true if this list contains the specified element.
     *
     * @param o Object The element to check if present in the list
     * @return boolean
     */
    public boolean contains(Object o) {
        Node temp = head;

        while (temp != null) {
            if (temp.value.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * 
     * Get the list entry corresponding to the value provided in the parameter.
     * 
     * @param o to search for
     * @return T matching data in the list
     */
    public T get(Object o) {
        Node temp = head;
        while (temp != null) {
            if (temp.value.equals(o)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 
     * Returns the element at the specified position in this list.
     *
     * @param index Integer The index at which to insert
     * @return T
     */
    public T get(int index) {
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            if (counter == index) {
                return temp.value;
            }
            counter++;
            temp = temp.next;
        }
        return null;
    }

    /**
     * 
     * Remove element at the specified position in this list.
     * Return element from the list or null if index is invalid.
     *
     * @param index element to be removed
     * @return element previously at the specified position or null
     */
    public T remove(int index) {
        int counter = 0;
        Node temp = head;
        T a = null;

        if (isEmpty()) {
            return null;
        }

        // if removing head
        if (index == 0 && temp != null) {
            if (temp.next == null) {
                a = head.value;
                head = null;
                return a;
            }
            // idk why I did it like this
            a = head.value;
            head = head.next;
            head.prev = null;
            return a;
        } else {
            while (temp != null) {
                if (counter == index) {
                    if (temp == tail) {
                        a = temp.value;
                        tail = temp.prev;
                        tail.next = null;
                    } else {
                        a = temp.value;
                        temp.prev.next = temp.next;
                        temp.next.prev = temp.prev;
                    }
                }
                temp = temp.next;
                counter++;
            }
        }

        return a;
    }

    /**
     * 
     * Removes the first occurrence of the specified element from this
     * list, if present.
     * If this list does not contain the element, it is unchanged.
     * Returns true if this list contained the specified element
     *
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    public boolean remove(Object o) {
        Node temp = head;

        if (temp != null && temp.value.equals(o)) {
            if (temp.next == null) {
                head = null;
                return true;
            }
            head = head.next;
            head.prev = null;
            return true;
        } else {
            while (temp != null) {
                if (temp.value.equals(o)) {
                    if (temp == tail) {
                        tail = temp.prev;
                        tail.next = null;
                    } else {
                        temp.prev.next = temp.next;
                        temp.next.prev = temp.prev;
                    }
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    /**
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @return int
     */
    public int size() {
        int counter = 0;
        Node temp = head;

        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    /**
     * 
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * 
     * Class represents an iterator over the elements in the linked list.
     */
    private class LinkedListIterator implements Iterator<T> {
        private Node current = head;

        /**
         * 
         * @return true if there are more elements
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * 
         * @return next element
         * @throws NoSuchElementException if there are no more elements to iterate over
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = current.value;
            current = current.next;
            return value;
        }
    }

    /**
     * 
     * Class represents a node in the linked list.
     */
    public class Node {
        public T value;
        public Node next;
        public Node prev;

        /**
         * 
         * @param value Store in the node
         */
        public Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
}