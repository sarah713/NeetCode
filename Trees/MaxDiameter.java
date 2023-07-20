package Trees;

public class MaxDiameter {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxD = new int[1];
        helper(root, maxD);
        return maxD[0];
    }

    public int helper(TreeNode root, int[] maxD) {
        if (root == null)
            return 0;

        int lh = helper(root.left, maxD);
        int rh = helper(root.right, maxD);

        maxD[0] = Math.max(maxD[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
