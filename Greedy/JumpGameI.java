package Greedy;

public class JumpGameI {
    // 2 pointer approach basically
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int stepsLeft = nums[0];
        int idx = 1;
        while (stepsLeft > 0) {
            if (idx == n - 1) {
                return true;
            }

            stepsLeft = Math.max(stepsLeft - 1, nums[idx]);
            idx++;
        }
        return false;
    }
}
