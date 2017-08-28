package src;

import java.util.ArrayList;

public class 整数中1出现的次数 {
    public static int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n = n / 10;
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(nums.length - 1 - i);
        }
        return numOf1(nums, 0);
    }

    public static int numOf1(int[] nums, int i) {
        if (i == nums.length - 1) {
            return nums[i] > 0 ? 1 : 0;
        }
        int numFirstDigit = nums[i] == 0 ? 0 : nums[i] > 1 ? (int) Math.pow(10, nums.length - 1 - i) : getNums(nums, i + 1) + 1;
        int numOtherDigit = nums[i] * (nums.length - 1 - i) * (int) Math.pow(10, nums.length - 2 - i);
        int numRecursive = numOf1(nums, i + 1);
        return numFirstDigit + numOtherDigit + numRecursive;
    }

    public static int getNums(int[] nums, int i) {
        int count = 0;
        int k = 1;
        for (int j = nums.length - 1; j >= i; j--) {
            count += nums[j] * k;
            k *= 10;
        }
        return count;
    }

}
