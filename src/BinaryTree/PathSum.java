package BinaryTree;

import java.util.LinkedList;

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

    /**
     * using linkedlist
     */
    public boolean hasPathSumiterative(TreeNode root, int sum) {
        if (root == null)
            return false;

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<Integer> sum_stack = new LinkedList();
        node_stack.add(root);
        sum_stack.add(sum - root.val);

        TreeNode node;
        int curr_sum;
        while ( !node_stack.isEmpty() ) {
            node = node_stack.poll(); // grabs the last item in stack
            curr_sum = sum_stack.poll(); // grabs the last item in stack
            if ((node.right == null) && (node.left == null) && (curr_sum == 0)) // if both childs are null AND sum is 0. that means you've reached the target and are at the end of the tree path.
                return true;

            if (node.right != null) { // if there's a TreeNode at .right
                node_stack.add(node.right); //we add it to node stack
                sum_stack.add(curr_sum - node.right.val); //we take the last number that we polled from the sum stack (curr_sum) and subtract it by the value of the .right nodetree.
                //basically, we're keeping track of the number and slowly chipping away.
            }
            if (node.left != null) { // if there's a TreeNode at .left
                node_stack.add(node.left); //we add it to node stack
                sum_stack.add(curr_sum - node.left.val); //add subtracted value to sum stack
            }
        }
        return false;
    }
}
