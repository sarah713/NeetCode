package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;

        helper(nums, 0, res, new ArrayList<>());
        return res;
    }

    public static void helper(int[] nums, int idx, List<List<Integer>> res, List<Integer> cur) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[idx]);
        helper(nums, idx + 1, res, cur);
        cur.remove(cur.size() - 1);
        helper(nums, idx + 1, res, cur);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(subsets(nums));
    }
}
