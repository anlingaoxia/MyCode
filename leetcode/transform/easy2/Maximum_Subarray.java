package transform.easy2;

public class Maximum_Subarray {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int thisSum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (thisSum <= 0) {
                thisSum = nums[i];
            } else {
                thisSum += nums[i];
            }
            if (thisSum > maxSum) {
                maxSum = thisSum;
            }

        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(input));
    }
}
