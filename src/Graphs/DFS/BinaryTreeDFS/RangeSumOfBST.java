package Graphs.DFS.BinaryTreeDFS;

/**
 * needs to be redone. DNF
 */
public class RangeSumOfBST {
    int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return ans;
    }
    void dfs(TreeNode root, int low, int high) {
        if(root == null) return;
        if (root.val >= low && root.val <= high) {
            ans += root.val;
        }
        dfs(root.left, low, high);
        dfs(root.right, low, high);
    }
}

