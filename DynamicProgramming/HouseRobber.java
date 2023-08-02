package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        Arrays.fill(dp, -1);
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
