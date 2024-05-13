/**
 * 
 * Represent BST data structure.
 * Allow adding node with key-value pairs to maintain BST property.
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class BST {

    private Node root;
    private int size;

    /**
     * 
     * @param keys to search for in list
     * @return array of string representing value with specified key
     */
    public String[] findAll(int[] keys) {
        String[] result = new String[keys.length];

        for (int i = 0; i < keys.length; i++) {
            result[i] = findValue(root, keys[i]);
        }
        return result;
    }

    /**
     * 
     * @param node being evaluated
     * @param key  to search for in tree
     * @return value associated with key
     */
    private String findValue(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            return findValue(node.left, key);
        } else if (key > node.key) {
            return findValue(node.right, key);
        } else {
            return node.value;
        }
    }

    /**
     * 
     * Add new node with specified key-value pair to BST.
     *
     * @param key   of node to be added
     * @param value associated with key
     */
    public void add(int key, String value) {
        Node node = new Node(key, value);

        if (root == null) {
            root = node;
            size++;
            return;
        }

        Node curr = root;
        while (curr != null) {
            if (key > curr.key) {
                if (curr.right == null) {
                    curr.right = node;
                    return;
                }
                curr = curr.right;
            } else if (key < curr.key) {
                if (curr.left == null) {
                    curr.left = node;
                    return;
                }
                curr = curr.left;
            } else {
                return;
            }
        }

    }

    /**
     *
     * @return root node of BST
     */
    public Node getRoot() {
        return root;
    }

    /**
     *
     * @return number of nodes in BST
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @return string representation of BST
     */
    public String toString() {
        String ret = toString(root, "", "");
        if (!ret.equals("")) {
            ret = ret.substring(0, ret.length() - 1);
        }
        return ret;
    }

    /**
     *
     * @param node   root node of subtree
     * @param indent current indentation for formatting
     * @param prefix prefix indicating position of node in parent
     * @return string representation of subtree rooted at node
     */
    public String toString(Node node, String indent, String prefix) {
        String ret = "";

        if (node != null) {
            ret += toString(node.left, indent + "    ", "L ");
            ret += indent + prefix + "(" + node.key + ", " + node.value + ")" + "\n";
            ret += toString(node.right, indent + "    ", "R ");
        }

        return ret;
    }

    /**
     * 
     * Represent node in BST.
     */
    public class Node {
        int key;
        String value;
        Node left;
        Node right;
        Node parent;

        /**
         * 
         * Construct new node with specified key-value pair.
         *
         * @param key   of node
         * @param value associated with key
         */
        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 
     * @param args command-line argument
     */
    public static void main(String[] args) {
        BST t = new BST();

        t.add(15, "F");
        t.add(21, "B");
        t.add(5, "M");
        t.add(18, "Z");
        t.add(10, "A");
        t.add(4, "V");

        System.out.println(t);
    }
}