/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class PhoneBook {
    TreeNode<String, String> root;

    /**
     * 
     * Construct a PhoneBook with a null root.
     */
    public PhoneBook() {

        root = null;

    }

    /**
     *
     * @param Name   to be added
     * @param Number associated with the name
     */
    public void add(String Name, String Number) {

        if (root == null) {
            root = new TreeNode<>(Name, Number);
        } else {
            addHelper(root, Name, Number);
        }
    }

    /**
     *
     * @param n current node being evaluated
     * @param k name to be added
     * @param v phone number associated with the name
     */
    private void addHelper(TreeNode<String, String> n, String k, String v) {

        int cmp = n.getKey().compareTo(k);

        if (cmp == 0) {
            n.setValue(v);
        } else if (cmp < 0) {

            if (n.right != null) {
                addHelper(n.right, k, v);
            } else {
                n.right = new TreeNode<>(k, v);
            }

        } else {
            if (n.left != null) {
                addHelper(n.left, k, v);
            } else {
                n.left = new TreeNode<>(k, v);
            }

        }

    }

    /**
     *
     * @param k name for the phone number to be retrieved
     * @return phone number associated with the name
     */
    public String get(String k) {
        return getHelper(root, k);
    }

    /**
     *
     * @param n current node being evaluated
     * @param k name for the phone number to be retrieved
     * @return phone number associated with the given name
     */
    public String getHelper(TreeNode<String, String> n, String k) {

        if (n == null) {
            return null;
        }

        int cmp = n.getKey().compareTo(k);
        if (cmp == 0) {
            return n.getValue();
        } else if (cmp < 0) {
            return getHelper(n.right, k);
        } else {
            return getHelper(n.left, k);
        }
    }

    /**
     *
     * @return string representation of the phone book
     */
    public String toString() {

        return stringHelper(root);

    }

    /**
     *
     * @param n current node being evaluated
     * @return string representation of the phone book
     */
    public String stringHelper(TreeNode<String, String> n) {

        if (n == null) {
            return "";
        } else {
            String l = stringHelper(n.left);
            String r = stringHelper(n.right);

            return l + "\n" + n + "\n" + r;
        }
    }

    /**
     *
     * @param args Command-line argument.
     */
    public static void main(String[] args) {

        PhoneBook b = new PhoneBook();

        b.add("A", "123-456-7880");
        b.add("B", "111-111-5555");
        b.add("A", "555-555-5555");
        System.out.println(b.get("A"));
        System.out.println(b.get("Z"));
        System.out.println(b.toString());
        String[] names = {"l", "n", "g", "r", "t", "d", "i", "x", "w", "a", "p"};
        for (String n : names) {
            b.add(n, "1");
        }
        System.out.println(b);
    }
}