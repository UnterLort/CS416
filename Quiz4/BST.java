/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class BST {

    Node root;

    /**
     * 
     * BST class represents a binary search tree.
     */
    public BST() {
    }

    /**
     * 
     * @param data to add to the tree
     */
    public void add(String data) {
        Node n = new Node(data);
        if (root == null) {
            root = n;
            return;
        }

        Node curr = root;
        boolean added = false;
        while (!added) {
            int c = curr.data.compareTo(data);
            if (c > 0) {
                if (curr.left == null) {
                    curr.left = n;
                    added = true;
                    n.parent = curr;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right == null) {
                    curr.right = n;
                    added = true;
                    n.parent = curr;
                } else {
                    curr = curr.right;
                }
            }
        }
    }

    /**
     * 
     * Node class represents a node in the tree.
     */
    public class Node {
        String data;
        Node left;
        Node right;
        Node parent;

        /**
         * 
         * @param data to be stored in node
         */
        public Node(String data) {
            this.data = data;
        }
    }

    /**
     * 
     * @return min value in tree
     */
    public String min() {
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }
}