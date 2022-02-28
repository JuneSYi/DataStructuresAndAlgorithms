package BinaryTree;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down
 * to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;

    }

    public static void main(String[] args) {
        TreeNode str = new TreeNode(15);
        TreeNode asd = new TreeNode(7);
        TreeNode fgg = new TreeNode(9);
        TreeNode gain = new TreeNode(20, str, asd);
        TreeNode init = new TreeNode(3, fgg, gain);
        MaximumDepthOfBinaryTree run = new MaximumDepthOfBinaryTree();
        System.out.println(run.maxDepth(init));

    }
}
