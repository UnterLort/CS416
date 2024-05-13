/**
 * 
 * Quiz 3.
 * 
 * @author Kyle Stewart
 * @version 1
 */

public class LinkedList {

    /**
     * 
     * Head of the linked list.
     */
    public class Node { // inner class
        int data;
        Node next;
        Node prev;

        /**
         * 
         * @param data Integer to be stored in this node.
         */
        public Node(int data) {
            this.data = data;
        }
    }

    public Node head;
    public Node tail;

    /**
     * 
     * Method to add a new node at the end of the linked list.
     */
    public LinkedList() {
        head = null;
        tail = null;
    }

    /**
     * 
     * @return number of elements in the list.
     */
    public int countOdd() {
        int count = 0;
        Node current = head;

        while (current != null) {
            if (current.data % 2 != 0) { // check if the data is odd
                count++;
            }
            current = current.next;
        }

        return count;
    }

    /**
     * @param val value to be added at the end of the list.
     */
    public void addInOrder(int val) {
        Node newNode = new Node(val);

        if (head == null) { // empty list
            head = newNode;
            tail = newNode;
            return;
        }

        if (val <= head.data) { // new value is less than or equal to the head data
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }

        Node current = head.next;
        Node previous = head;

        while (current != null && val > current.data) {
            previous = current;
            current = current.next;
        }

        if (current == null) { // new value is greater than all existing values
            previous.next = newNode;
            newNode.prev = previous;
            tail = newNode;
        } else { // new value should be inserted between previous and current nodes
            previous.next = newNode;
            newNode.prev = previous;
            newNode.next = current;
            current.prev = newNode;
        }
    }

    /**
     * 
     * @param data integer to search for in the linked list.
     */
    public void addHead(int data) {
        Node n = new Node(data);
        if (head == null) { // empty list
            tail = n;
        } else {
            head.prev = n;
        }
        n.next = head;

        head = n;
    }

    /**
     * @param data integer to remove from the linked list.
     */
    public void addTail(int data) {
        Node n = new Node(data);
        if (tail == null) { // empty list
            head = n;
        } else {
            tail.next = n;
        }
        n.prev = tail;
        tail = n;
    }

    /**
     * 
     * @return true if the linked list is empty
     */
    public Node getHead() {
        return head;
    }

    /**
     * 
     * @return the number of elements in the linked list
     */
    public Node getTail() {
        return tail;
    }

    /**
     * 
     * Class represent a node for doubly linked list. Each node contains one
     * element and two links.
     * 
     * @return inner class represent single node in the Doubly Linked List.
     */
    public String toString() {
        String res = "";

        Node curr = head;

        if (curr != null) {
            res += curr.data;
            curr = curr.next;
        }

        while (curr != null) {
            res += ", " + curr.data;
            curr = curr.next;
        }

        return res;
    }
}