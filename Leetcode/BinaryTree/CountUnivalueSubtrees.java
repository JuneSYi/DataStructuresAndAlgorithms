package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/** POORLY WORDED QUESTION.
 * Given the root of a binary tree, return the number of uni-value subtrees.
 *
 * A uni-value subtree means all nodes of the subtree have the same value.
 */
public class CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int val = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.val == root.val) val++;
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return val;
    }
}
