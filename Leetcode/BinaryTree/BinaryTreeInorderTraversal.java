package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    //iterative
    public List<Integer> inOrderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) { // adds all the nodes until no more .left
                stack.push(root);
                root = root.left;
            }
            root = stack.pop(); // pops
            list.add(root.val); //adds to list
            root = root.right; // next iteration will start with .right, if null, it'll skip the .push and go to .pop
        }
        return list;
    }
}
