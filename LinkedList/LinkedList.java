/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class LinkedList {

    /**
     * 
     * Internal Node class used for the linked list.
     */
    public class Node {
        String key;
        int value;
        Node next;

        /**
         * 
         * @param key   The Key
         * @param value The Value
         */
        public Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    /**
     * 
     * The default constructor.
     */
    public LinkedList() {
        head = null;
        tail = null;
    }

    /**
     * 
     * @param key The Key
     * @param val The Value
     *
     */
    public void addHead(String key, int val) {
        Node n = new Node(key, val);

        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    /**
     * 
     * @param key The Key
     * @param val The Value
     */
    public void addTail(String key, int val) {
        Node n = new Node(key, val);

        if (tail == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    /**
     * 
     * @return String The String format.
     */
    public String toString() {
        StringBuilder ret = new StringBuilder();
        Node curr = head;

        while (curr != null) {
            ret.append(curr.key).append(":").append(curr.value);
            if (curr.next != null) {
                ret.append(", ");
            }
            curr = curr.next;
        }

        return ret.toString();
    }

    /**
     * 
     * @param key The key to find in the LinkedList
     * @return Node Returns the Node with the given key or null if non-existent.
     */
    private Node find(String key) {
        Node curr = head;

        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr;
            }

            curr = curr.next;
        }

        return null;
    }

    /**
     * Removes the Node with the given key from the linkedlist.
     * 
     * @param key The key to remove from the LinkedList
     * @return boolean Returns true if the key was found and removed, false
     *         otherwise.
     */
    public boolean remove(String key) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev == null) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }

                if (curr == tail) {
                    tail = prev;
                }

                return true;
            }

            prev = curr;
            curr = curr.next;
        }

        return false;
    }

    /**
     * 
     * @param list The original linked list
     * @return LinkedList The reversed linked list
     */
    public static LinkedList reversed(LinkedList list) {
        LinkedList reversedList = new LinkedList();
        Node current = list.head;
        while (current != null) {
            reversedList.addHead(current.key, current.value);
            current = current.next;
        }
        return reversedList;
    }

    /**
     * 
     * @param list the list
     * @return the average
     */
    public static double average(LinkedList list) {
        if (list.head == null) {
            return 0;
        }

        Node curr = list.head;
        double sum = 0;
        int count = 0;
        while (curr != null) {
            sum += curr.value;
            count++;
            curr = curr.next;
        }

        return sum / count;
    }

    /**
     * 
     * @param list the list
     * @return true if the list is in non-decreasing order, false otherwise
     */
    public static boolean ordered(LinkedList list) {
        Node curr = list.head;
        while (curr != null && curr.next != null) {
            if (curr.value > curr.next.value) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    /**
     * 
     * @param list the list
     * @return the compressed list
     */
    public static LinkedList compressList(LinkedList list) {
        LinkedList compressedList = new LinkedList();
        Node curr = list.head;
        while (curr != null) {
            Node existingNode = compressedList.find(curr.key);
            if (existingNode != null) {
                existingNode.value += curr.value;
            } else {
                compressedList.addTail(curr.key, curr.value);
            }
            curr = curr.next;
        }
        return compressedList;
    }
}