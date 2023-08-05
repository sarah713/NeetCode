package DynamicProgramming;

public class PartitionEqualSubset {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 != 0) {
            return false;
        }

        return subsetSum(nums, sum / 2);
    }

    public boolean subsetSum(int[] nums, int sum) {
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int j = 0; j < dp.length; j++) {
            dp[j][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }

}
