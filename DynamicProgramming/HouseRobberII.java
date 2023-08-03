package DynamicProgramming;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int one = helper(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int two = helper(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(one, two);
    }

    public int helper(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int take = nums[i];

            if (i > 1) {
                take += dp[i - 2];
            }
            int dont = dp[i - 1];

            dp[i] = Math.max(take, dont);
        }
        return dp[nums.length - 1];
    }
}
