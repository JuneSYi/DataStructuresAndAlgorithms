package Amazon.TreeAndGraphs;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        int original = root.val;
        leftTree(root, original);
        rightTree(root, original);
        return true;
    }

    public boolean leftTree(TreeNode root, int original) {
        if (root.left !=null) {
            if (root.left.val>= original) return false;
            leftTree(root.left, original);
        }
        if (root.right != null) {
            if (root.right.val >= original) return false;
            leftTree(root.right, original);
        }
        return true;
    }

    public boolean rightTree(TreeNode root, int original) {
        if (root.left !=null) {
            if (root.left.val<= original) return false;
            rightTree(root.left, original);
        }
        if (root.right != null) {
            if (root.right.val <= original) return false;
            rightTree(root.right, original);
        }
        return true;
    }

//    public boolean optimal(TreeNode root) {
//
//    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
