/**
 * 
 * @author Kyle Stewart
 * @version 1
 * @param <K> type of the key
 * @param <V> type of the value
 */
public class TreeNode<K extends Comparable, V> {

    K key;
    V value;
    TreeNode right;
    TreeNode left;

    /****
     * 
     * @param key   key of the node
     * @param value value associated with the key
     */
    public TreeNode(K key, V value) {

        this.key = key;
        this.value = value;
        right = null;
        left = null;
    }

    /**
     * 
     * @return key of the node
     */
    public K getKey() {

        return key;
    }

    /**
     *
     * @param value new value to be set
     */
    public void setValue(V value) {

        this.value = value;
    }

    /**
     *
     * @return value associated with the key
     */
    public V getValue() {

        return value;
    }

    /**
     *
     * @return string representation of the key-value pair
     */
    public String toString() {

        return key + "  ->  " + value;
    }

    /**
     *
     * @param args Command-line argument.
     */
    public static void main(String[] args) {

        TreeNode t1 = new TreeNode("A", 1);
        TreeNode t2 = new TreeNode(1, "Apple");

        assert t1.getKey().equals("A");
        assert t1.getValue().equals(1);
        assert t1.toString().equals("A  -> 1");

        t2.setValue("Zebra");

        assert t2.getKey().equals(1);
        assert t2.getValue().equals("Zebra");
        assert t2.toString().equals("1  -> Zebra");

        System.out.println(t1);
        System.out.println(t2);
    }
}