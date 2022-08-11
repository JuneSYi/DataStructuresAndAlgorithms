package BinaryTree.Medium;

import java.util.PriorityQueue;
import java.util.Stack;

public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            queue.add(root.val);
            root = root.right;
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = queue.poll();
        }
        return ans;
    }
}
