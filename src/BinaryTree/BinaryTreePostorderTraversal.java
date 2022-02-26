package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    List<Integer> graph = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return graph;
    }
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        graph.add(root.val);
    }
}
