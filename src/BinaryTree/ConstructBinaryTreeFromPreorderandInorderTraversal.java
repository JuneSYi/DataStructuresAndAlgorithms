package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderandInorderTraversal {
    //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    Map<Integer, Integer> map = new HashMap<>();
    int count;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0; i < inorder.length; i++) {
            map.put(inorder[i], i); // we know preorder starts with root, we'll map out values of inorder and use to create tree
        }
        count = 0; //start count from 0 as that will be root when we use preorder
        TreeNode ans = dfs(0, inorder.length, preorder); // recursion
        return ans;
    }

    private TreeNode dfs(int start, int end, int[] preorder) {
        if(start>end) return null; // base case
        if(count==preorder.length) return null;
        int value = preorder[count]; //we start with initial value of preorder, which is root
        count++;
        int index = map.get(value); // we get the index of where it exists on inorder.
        /*
        using inorder, we know the left of root is tree.left, right of root is tree.right.
        tying this knowledge into knowing preorder is root->left->right. we can build our tree starting with the node value of root.
        building tree.left value through preorder[count+1],
        the next .left value will be 9 because index-1 (which is int end),
        is equal to 0.
        count will = 1 this time.
        int value will = 9.
        9 will be added to cur as a TreeNode.
        .left will return null because index is 0, so start will be > end
        same for .right
        return cur all the way to cur.right for root

         */

        TreeNode cur = new TreeNode(value);
        cur.left = dfs(start, index-1, preorder);
        cur.right = dfs(index+1, end, preorder);
        return cur;
    }
}
