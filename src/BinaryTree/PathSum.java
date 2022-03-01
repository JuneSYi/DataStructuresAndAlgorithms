package BinaryTree;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 */
public class PathSum {
    boolean found = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int tally = 0;
        dfs(root, tally, targetSum);
        return found;
    }

    private void dfs(TreeNode root, int tally,  int targetSum) {
        if(root==null) return;
        tally+=root.val;
        if(root.left != null) dfs(root.left,tally,targetSum);
        if(root.right != null) dfs(root.right,tally,targetSum);
        if(tally==targetSum && root.left == null && root.right == null) {
            found = true;
            return;
        }
    }

    /**
     * another variation using recursion
     */
    public boolean hasPathSumTwo(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val; // subtracts from the total at every node
        if ((root.left == null) && (root.right == null)) return (sum == 0); // when no child nodes are left, returns true or false
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum); // || of either node, if one is true, it'll return that one
    }
}
