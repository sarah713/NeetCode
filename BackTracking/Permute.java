package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;

        helper(nums, 0, res);
        return res;
    }

    public void helper(int[] nums, int idx, List<List<Integer>> res) {
        if (idx == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int i : nums) {
                cur.add(i);
            }
            res.add(cur);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            helper(nums, idx + 1, res);
            swap(nums, idx, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
