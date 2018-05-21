package sort.unstable;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 6, 8, 7, 2, 3, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
