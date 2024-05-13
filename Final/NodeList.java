import java.util.ArrayList;

/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class NodeList {

    Node head;
    Node tail;

    /**
     * 
     * Node class represent individual node in doubly linked list.
     */
    public class Node { // inner class
        String key;
        int data;
        Node next;
        Node prev;

        /**
         * Construct new Node with given key and data.
         * 
         * @param key  associated with node
         * @param data stored in node
         */
        public Node(String key, int data) {
            this.key = key;
            this.data = data;
        }
    }

    /**
     * 
     * Find all occurrence of key in NodeList.
     * 
     * @param key to search for in list
     * @return ArrayList of integer representing data value with key
     */
    public ArrayList<Integer> findAll(String key) {
        ArrayList<Integer> result = new ArrayList<>();

        Node curr = head;
        while (curr != null) {
            if (curr.key.equals(key)) {
                result.add(curr.data);
            }
            curr = curr.next;
        }
        return result;
    }

    /**
     * Add new node with given key and data at head of list.
     * 
     * @param key  for new node
     * @param data for new node
     */
    public void addHead(String key, int data) {
        Node n = new Node(key, data);
        if (head == null) { // empty list
            tail = n;
        } else {
            head.prev = n;
        }
        n.next = head;

        head = n;
    }

    /**
     * 
     * Add new node with given key and data at tail of list.
     * 
     * @param key  for new node
     * @param data for new node
     */
    public void addTail(String key, int data) {
        Node n = new Node(key, data);
        if (tail == null) { // empty list
            head = n;
        }
        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    /**
     * 
     * @return string representation of list
     */
    public String toString() {
        String ret = "";

        Node curr = head;
        while (curr != null) {
            ret += "( " + curr.key + ", " + curr.data + " ) ";
            curr = curr.next;
        }

        return ret;
    }
}