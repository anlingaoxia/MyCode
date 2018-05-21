package array;

import java.util.Arrays;

public class N075 {
    public void sortColors(int[] nums) {
        int[] nHash = new int[3];
        for (int i : nums) {
            nHash[i]++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < nHash[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    public static void sortColorsOther(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i <= end && start < end; ) {
            if (nums[i] == 2) {
                System.out.println("2");
                System.out.println(Arrays.toString(nums));
                swap(nums, i, end);
                end--;
                System.out.println(Arrays.toString(nums));
                System.out.println("=====");
            } else if (nums[i] == 0) {
                if (i == start) i++;
                else {
                    System.out.println("0");
                    System.out.println(Arrays.toString(nums));
                    swap(nums, i, start++);
                    System.out.println(Arrays.toString(nums));
                    System.out.println("=====");
                }
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        sortColorsOther(nums);
        System.out.println(Arrays.toString(nums));
    }


}
