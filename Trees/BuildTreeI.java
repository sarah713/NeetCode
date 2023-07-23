package Trees;

import java.util.Arrays;

public class BuildTreeI {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int leftIdx = 0;
        while (leftIdx < inorder.length && inorder[leftIdx] != root.val) {
            leftIdx++;
        }
        TreeNode leftTree = buildTree(Arrays.copyOfRange(preorder, 1, leftIdx + 1),
                Arrays.copyOfRange(inorder, 0, leftIdx));
        TreeNode rightTree = buildTree(Arrays.copyOfRange(preorder, leftIdx + 1, preorder.length),
                Arrays.copyOfRange(inorder, leftIdx + 1, inorder.length));
        if (leftTree != null)
            root.left = leftTree;
        if (rightTree != null)
            root.right = rightTree;
        return root;
    }
}
