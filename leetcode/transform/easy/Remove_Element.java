package transform.easy;

import java.util.Arrays;

public class Remove_Element {
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) count++;
        }
        return count;

    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 3 };
        int a = removeElement(nums, 3);
        System.out.println(a);
        System.out.println(Arrays.toString(nums));
    }
}
