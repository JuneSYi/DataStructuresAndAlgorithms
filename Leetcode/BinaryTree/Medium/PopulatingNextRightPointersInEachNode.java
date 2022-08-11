package BinaryTree.Medium;

import BinaryTree.Medium.TreeNode;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * e.g.
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer
 * to point to its next right node, just like in Figure B. The serialized output is in level order as connected
 * by the next pointers, with '#' signifying the end of each level.
 */

public class PopulatingNextRightPointersInEachNode {
    public TreeNode connect(TreeNode root) {
        populate(root.left, root.right);
        return root;
    }

    private void populate(TreeNode rootleft, TreeNode rootright) {
        rootleft.next = rootright;
        if(rootleft.left != null) {
            populate(rootleft.right, rootright.left);
            populate(rootleft.left, rootleft.right);
            populate(rootright.left, rootright.right);
        }
        /* binary tree isn't changing. so .left and .right remains the same
        we add a next value that points to the correct path
        (a)root.next will equal null
        (b)root.left.next will point to (c)root.right
        (c)root.right.next will equal null

        then we start again
        (d)tree.left.next will point to (e)tree.right
        (e)tree.right

        how do we check if there is a tree.right?
        could we make 2 separate functions where all of tree.right starting from root, point to null
        then another function where everything else points to something. no.
         */
    }
}
