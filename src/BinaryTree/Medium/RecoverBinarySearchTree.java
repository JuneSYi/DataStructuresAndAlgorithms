package BinaryTree.Medium;

public class RecoverBinarySearchTree {
    /**
     * my stupid solution that doesn't even work
     */
    public void recoverTree(TreeNode root) {
        TreeNode temp = root;
        // traverse right
        if (checkright(root, root.right)) {
            flipright(root, root.right);
        }

        if (checkleft(root, root.left)) {
            flipleft(root, root.left);
        }
    }

    private boolean checkright(TreeNode original, TreeNode sub) {
        if (sub == null) return false;

        if (original.val > sub.val) return true;
        checkright(original, sub.right);
        checkright(original, sub.left);
        return false;
    }

    private boolean checkleft(TreeNode original, TreeNode sub) {
        if (sub == null) return false;

        if (original.val < sub.val) return true;
        checkright(original, sub.right);
        checkright(original, sub.left);
        return false;
    }

    private void flipright(TreeNode original, TreeNode sub) {
        if (sub == null) return;

        if (original.val > sub.val) {
            int temp = original.val;
            original.val = sub.val;
            sub.val = temp;
        }
        checkright(original, sub.right);
        checkright(original, sub.left);
    }

    private void flipleft(TreeNode original, TreeNode sub) {
        if (sub == null) return;

        if (original.val < sub.val) {
            int temp = original.val;
            original.val = sub.val;
            sub.val = temp;
        }
        checkright(original, sub.right);
        checkright(original, sub.left);
    }
}
jk