package transform.easy;

public class Missing_Number {
    public static int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (1 + nums.length) * nums.length / 2 - sum;
    }

    public static void main(String[] args) {
        int[] input = { 1, 0 };
        System.out.println(missingNumber(input));

    }

}
