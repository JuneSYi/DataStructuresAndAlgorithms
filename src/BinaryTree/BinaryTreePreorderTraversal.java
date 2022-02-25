package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Pre-order traversal is to visit the root first. Then traverse the left subtree. Finally, traverse the right subtree.
 *     - starts with root, enters every node it meets along the way down immediately.
 */
public class BinaryTreePreorderTraversal {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return ans;
        dfs(root);
        return ans;
    }
    void dfs(TreeNode root) {
        if (root == null) return;
        ans.add(root.val);
        dfs(root.left);
        dfs(root.right);

    }
}