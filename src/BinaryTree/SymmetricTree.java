package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root); //dfs
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) return t1 == t2; // if one is null, return false
        if (t1.val!=t2.val) return false;
        return isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    public boolean isSymmetricWithBFS(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList(); // start off with a queue

        q.add(root.left); // add .left and .right
        q.add(root.right);
        while(!q.isEmpty()){ //while queue has value
            TreeNode left = q.poll(); // takes the first value and assigns it to left
            TreeNode right = q.poll();  // takes the next value and assign it to right
            // we can do this because we always put it in the same order of left node and then right node
            if(left == null && right == null) //if both are null, continue. why? there's more values afterwards
                // see 4 lines below. it means symmetry is there if both null. also more to check so continue
                continue;
            if(left == null || right == null ||left.val != right.val ) // if one of them are null, then not mirror
                // we can ask this because we've already checked if they're both null
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);

        }
        return true;
    }
}
