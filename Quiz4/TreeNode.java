/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class TreeNode {

    String data;
    TreeNode left;
    TreeNode right;

    /**
     * 
     * @param data to set
     */
    public TreeNode(String data) {
        this.data = data;
    }

    /**
     * 
     * @return TreeNode
     */
    public static TreeNode buildTree() {
        TreeNode root = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeG = new TreeNode("G");
        TreeNode nodeH = new TreeNode("H");
        TreeNode nodeI = new TreeNode("I");

        root.left = nodeB;
        root.right = nodeC;
        nodeB.left = nodeD;
        nodeD.left = nodeE;
        nodeD.right = nodeF;
        nodeC.right = nodeG;
        nodeG.left = nodeH;
        nodeG.right = nodeI;

        return root;
    }
}