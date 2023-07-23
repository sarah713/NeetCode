package Trees;

public class MaxSumPath {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = Math.max(helper(root.left), 0);
        int rightSum = Math.max(helper(root.right), 0);
        int sum = root.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, sum);
        return root.val + Math.max(leftSum, rightSum);
    }
}
