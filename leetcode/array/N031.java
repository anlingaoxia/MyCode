package array;

import java.util.Arrays;

public class N031 {
    public static void nextPermutation(int[] nums) {
        int index = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int swap = nums.length - 1;
                for (int j = nums.length - 1; j > i - 1; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap = j;
                        break;
                    }
                }
                int t = nums[i - 1];
                nums[i - 1] = nums[swap];
                nums[swap] = t;
                index = i;
                break;
            }
        }
        for (int i = index, j = nums.length - 1; i < j; i++, j--) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1};
        nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }

}
