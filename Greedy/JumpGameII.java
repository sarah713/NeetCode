package Greedy;

public class JumpGameII {
    public int jump(int[] nums) {
        int jump = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                curEnd = curFarthest;
                jump++;
            }
        }
        return jump;
    }
}
