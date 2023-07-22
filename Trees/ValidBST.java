package Trees;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);

    }
}
