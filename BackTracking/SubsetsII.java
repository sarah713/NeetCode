package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int idx, List<List<Integer>> res, List<Integer> cur) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            cur.add(nums[i]);
            helper(nums, i + 1, res, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
