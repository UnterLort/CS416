/**
 * 
 * Binary Search Tree implementation.
 *
 * This class implements a binary search tree data structure. It allows adding,
 * removing,
 * searching for elements, and other operations on a binary tree where each node
 * has at most two
 * children.
 *
 * @author Kyle Stewart
 * @version 1
 * @param <T> type of elements stored in the BST, must implement Comparable
 *            interface.
 */
public class BST<T extends Comparable> implements Tree<T> {

    /**
     * 
     * Inner class representing node in the binary search tree.
     */
    public class Node {
        private T value;
        private Node left;
        private Node right;
        private Node parent;

        /**
         * 
         * Constructs a node with the given value.
         *
         * @param value to be stored in the node.
         */
        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        /**
         *
         * @param value for the node.
         */
        public void setValue(T value) {
            this.value = value;
        }

        /**
         *
         * @return value stored in the node.
         */
        public T getValue() {
            return value;
        }

        /**
         *
         * @return left child node.
         */
        public Node getLeft() {
            return left;
        }

        /**
         *
         * @return right child node.
         */
        public Node getRight() {
            return right;
        }

        /**
         *
         * @return parent node.
         */
        public Node getParent() {
            return parent;
        }
    }

    private Node root;
    private int size;

    /**
     * 
     * Construct a empty binary search tree.
     */
    public BST() {
        this.root = null;
        this.size = 0;
    }

    /**
     *
     * @return root node of the tree.
     */
    public Node getRoot() {
        return root;
    }

    /**
     *
     * @param value to add.
     * @return true if the value was successfully added.
     */
    public boolean add(T value) {
        if (contains(value)) {
            return false; // No duplicate allowed
        }
        root = addRecursive(root, value);
        size++;
        return true;
    }

    /**
     * 
     * @param current node
     * @param value   type value
     * @return value
     */
    private Node addRecursive(Node current, T value) {
        if (current == null) {
            return new Node(value);
        }

        if (value.compareTo(current.getValue()) < 0) {
            current.left = addRecursive(current.left, value);
            current.left.parent = current;
        } else {
            current.right = addRecursive(current.right, value);
            current.right.parent = current;
        }

        return current;
    }

    @Override
    public String toString() {
        return toStringRecursive(root, 0);
    }

    /**
     * 
     * @param current Node
     * @param level   int
     * @return toString
     */
    private String toStringRecursive(Node current, int level) {
        StringBuilder builder = new StringBuilder();

        if (current != null) {
            builder.append(toStringRecursive(current.right, level + 1));
            for (int i = 0; i < level; i++) {
                builder.append("      ");
            }
            if (current.parent != null && current.parent.left == current) {
                builder.append("L:");
            } else if (current.parent != null && current.parent.right == current) {
                builder.append("R:");
            }
            builder.append(current.getValue()).append("\n");
            builder.append(toStringRecursive(current.left, level + 1));
        }

        return builder.toString();
    }

    /**
     * 
     * Removes all elements from the binary search tree.
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     *
     * @param o object to search for.
     * @return value associated with the specified object.
     */
    public T get(Object o) {
        if (o == null || root == null) {
            return null;
        }
        @SuppressWarnings("unchecked")
        T value = (T) o;
        Node resultNode = getRecursive(root, value);
        return resultNode != null ? resultNode.getValue() : null;
    }

    /**
     * 
     * @param current node
     * @param value   the type
     * @return null or recursive value
     */
    private Node getRecursive(Node current, T value) {
        if (current == null) {
            return null;
        }

        int cmp = value.compareTo(current.getValue());
        if (cmp == 0) {
            return current;
        } else if (cmp < 0) {
            return getRecursive(current.left, value);
        } else {
            return getRecursive(current.right, value);
        }
    }

    /**
     * 
     * Checks whether the binary search tree contains the specified object.
     *
     * @param o object to search for.
     * @return true if the tree contains the object.
     */
    public boolean contains(Object o) {
        return get(o) != null;
    }

    /**
     * 
     * Check if the binary search tree is empty.
     *
     * @return true if the tree is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Remove the specified object from the binary search tree.
     *
     * @param o object to remove.
     * @return true if the object was found and removed.
     */
    public boolean remove(Object o) {
        if (o == null || root == null) {
            return false;
        }
        @SuppressWarnings("unchecked")
        T value = (T) o;
        int initialSize = size;
        root = removeRecursive(root, value);
        return size < initialSize;
    }

    /**
     * 
     * @param current node
     * @param value   the type
     * @return null
     */
    private Node removeRecursive(Node current, T value) {
        if (current == null) {
            return null;
        }

        int cmp = value.compareTo(current.getValue());
        if (cmp < 0) {
            current.left = removeRecursive(current.left, value);
        } else if (cmp > 0) {
            current.right = removeRecursive(current.right, value);
        } else {
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                current.setValue(findMin(current.right).getValue());
                current.right = removeRecursive(current.right, current.getValue());
            }
        }
        return current;
    }

    /**
     * 
     * @param node the node
     * @return node
     */
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     *
     * @return number of element in the tree.
     */
    public int size() {
        return size;
    }
}