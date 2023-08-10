package Greedy;

public class MaxSubarray {
    public static int maxSubArray(int[] nums) {
        int max_till_now = 0, max_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max_till_now += nums[i];
            if (max_till_now > max_sum) {
                max_sum = max_till_now;
            }
            if (max_till_now < 0) {
                max_till_now = 0;
            }
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 4, -1, 7, 8 };
        System.out.println(maxSubArray(nums));
    }
}
