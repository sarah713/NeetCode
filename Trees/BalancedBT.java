package Trees;

public class BalancedBT {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int lh = height(root.left);
        int rh = height(root.right);

        int diff = Math.abs(lh - rh);
        if (diff > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + Math.max(lh, rh);
    }
}
