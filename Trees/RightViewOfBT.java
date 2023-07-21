package Trees;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBT {
    int maxLevel = 0;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 1, res);
        return res;
    }

    public void helper(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (level > maxLevel) {
            res.add(root.val);
            maxLevel = level;
        }

        helper(root.right, level, res);
        helper(root.left, level, res);
    }
}
