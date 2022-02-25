package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * In-order traversal is to traverse the left subtree first. Then visit the root. Finally, traverse the right subtree.
 *     - goes all the way down to bottom child and starts from there. starts recording from child and up.
 */
public class BinaryTreeInorderTraversal {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root==null) {
            return;
        }
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
}
