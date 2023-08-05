package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSub {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j - 1]);
                }
            }
        }

        int max = 0;
        for (int len : dp) {
            max = Math.max(max, len);
        }
        return max;
    }
}
