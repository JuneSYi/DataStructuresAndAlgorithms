package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** Medium
 *
 * Given two integer arrays inorder and postorder where inorder is the inorder
 * traversal of a binary tree and postorder is the postorder traversal of the same tree,
 * construct and return the binary tree.
 */
public class ConstructBinaryTreeFromInorderandPostOrderTraversal {
    /*
    Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    Output: [3,9,20,null,null,15,7]

    during preorder traversal, the first value is its root
    during postorder, the last value is the root

    knowing that in post order, 3 is the root. we know that in inorder, everything to the right of 3 is right tree.
    everything to the left of 3 is left tree.
    all TreeNodes to the right of root = 9
    root = 3
    all TreeNodes to the right of root = 15, 20, 7

    not 100%: but since we know that 20 is a node.right because it's to the right of root on inorder.
    we also know that 7 must be node.right since it's to the right of 20 on inOrder
    we know that 15 must be a node.left since it's to the left of 20 on inOrder
    we know that 9 is node.left
     */
    /**
     * Solution
     * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/1589310/C%2B%2BPython-2-Simple-Solutions-w-Images-and-Detailed-Explanation-or-Recursion-%2B-Hashmap
     * But, when we consider both traversals, we can form a unique tree. Since the postorder traversal ends with
     * root node, we know the root node of tree is last node of postorder. At the same time, we can search for
     * that node in inorder and we know that the nodes that occur to its left form its left sub-tree and nodes
     * occurring to the right of it form its right sub-tree. We recursively repeat the same process -
     */
    int orderIndex;
    int[] postorder; //[9,15,7,20,3]
    int[] inorder; // [9,3,15,20,7]
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  //initializing a map

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // start from the last postorder element
        int n = postorder.length;
        orderIndex = n - 1;

        // build a hashmap value -> its index
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i); //we map out the hashmap according to the values of inorder[], repesented in the
            //keys, the value of it goes up for every key? idx repesents maybe the index?
        }

        TreeNode ans = dfs(0, n-1);
        return ans;
    }

    public TreeNode dfs(int start, int end) {
        if (start > end) return null;
        int currentVal = postorder[orderIndex];
        TreeNode curTree = new TreeNode(currentVal);

        int index = map.get(currentVal);
        orderIndex--;

        curTree.right = dfs(index + 1, end);
        curTree.left = dfs(start, index - 1);
        return curTree;
    }

    public TreeNode dfsExplained(int start, int end) {
        // base case
        // if there is no elements to construct subtrees
        if (start > end)
            return null;

        // build the current node
        // pick up post_idx element as a root
        int currentVal = postorder[orderIndex]; //currentVal = last value of postorder (which will start with root value)
        // orderIndex will decrement every iteration (--) so we'll go through the values of postOrder starting at the end
        TreeNode curTree = new TreeNode(currentVal); //we make curTree = TreeNode with value of currentVal
        //this is the TreeNode creation process

        // root splits inorder list -- wtf does this mean
        // into left and right subtrees
        int index = map.get(currentVal); // map.get(3), value = 1 -- since 3 is index 1 on inorder
        /*  Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
         the next map.get(currentval) will be postorder[orderIndex-1], so index 3, since that is the first node.right
         we know, because of how inorder goes, that on inorder[], the numbers to the left and right of node.right will
         be the child nodes.
         */

        orderIndex--; // total shrank by 1
        // build right subtree
        curTree.right = dfs(index + 1, end); // why use index? because index represents parent node. so to the right of parent node
        // is going to start at the index value + 1.
        /* curTree.right = dfs(1+1,end)
        if we continue here, currentVal = postorder[orderIndex-1 of original, so 3]
        currentVal = postOrder[3] which is 20
        we create TreeNode of value 20.
        index = map.get(20) = 3
        curTree.right = dfs(4, end).
         */

        // build left subtree
        curTree.left = dfs(start, index - 1);
        return curTree;
    }

    //-----------------------------------------------------------------------------------
    List<Integer> in = new ArrayList<>();
    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        in.add(node.val);
        inOrder(node.right);
    }

    List<Integer> post = new ArrayList<>();
    private void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        post.add(node.val);
    }
}
