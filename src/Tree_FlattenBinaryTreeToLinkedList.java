
/**
 * TODO in progress
 * Problem statement : Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 * Next challenge : solve this in O(1) space i.e. modify existing tree
 *
 * @author Unmesh Chougule
 */
public class Tree_FlattenBinaryTreeToLinkedList {

    public static void main(String []args) {
        TreeNode root = createTree();
        TreeNode nRoot = new TreeNode(); // new tree having flattened elements from original tree
        dfs(root, nRoot);
        //verify new tree has only right nodes
    }

    //pre order - uses O(N) extra space to solve
    private static void dfs(TreeNode node, TreeNode nNode) {
        if(node == null) return;

        //add the node in new tree here
        dfs(node.left, nNode.right);
        dfs(node.right, nNode.right);
    }

    //TODO improve
    //will use O(1) i.e. no extra space to solve
    private static void dfs_improved(TreeNode node) {
        //
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
    }
}