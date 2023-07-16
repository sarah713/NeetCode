package BinarySearch;

public class FindMinInRotatedArr {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        } else {
            int breakpt = -1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] < nums[i]) {
                    breakpt = i;
                }
            }
            return nums[breakpt + 1];
        }
    }
}
