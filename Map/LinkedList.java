/**
 * 
 * Doubly Linked List.
 * 
 * @author Kyle Stewart
 * @version 12
 * @param <T> Type of the object being compared for equality and hash code
 *            generation.
 */
public class LinkedList<T> extends List<T> {
    public Node head;
    public Node tail;
    private int size;

    /**
     * 
     * Constructor for an empty linked list.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public boolean add(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        if (index == size) {
            add(value); // If index is at the end, simply add
            return;
        }

        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node current = getNodeAtIndex(index);
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public T get(Object o) {
        if (o == null) {
            o = false;
        }
        Node current = head;
        while (current != null) {
            if (o.equals(current.value)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 
     * @param o Element to search in the list.
     * @return First index at which the element appears.
     */
    public int indexOf(Object o) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (o.equals(current.value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            if (size == 1) {
                tail = null;
            }
        } else if (index == size - 1) {
            removedNode = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            Node current = getNodeAtIndex(index);
            removedNode = current;
            removedNode.next = current.next;
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return removedNode.value;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 
     * @param index Position to look for in this list of elements.
     * @return Node at the given position or null.
     */
    private Node getNodeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    /**
     *
     * @return the head node of this list
     */
    public Node getHead() {
        return head;
    }

    /**
     * 
     * @return the tail node of this list
     */
    public Node getTail() {
        return tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}