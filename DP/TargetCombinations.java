package DP;

public class TargetCombinations {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, 0, target);
    }

    public int helper(int[] nums, int idx, int sum, int target) {
        if (idx == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int left = helper(nums, idx + 1, sum + nums[idx], target);
        int right = helper(nums, idx + 1, sum - nums[idx], target);
        return left + right;
    }
}
