package Trees;

public class KthSmallest {
    int count;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = 0;
        inorder(root, k);
        return result;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorder(root.left, k);

        count += 1;
        if (count == k) {
            result = root.val;
            return;
        }

        inorder(root.right, k);
    }
}
