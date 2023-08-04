package DynamicProgramming;

public class MaxProdSubarray {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }

            max = Math.max(num, max * num);
            min = Math.min(num, min * num);

            maxProd = Math.max(maxProd, max);
        }
        return maxProd;
    }
}
