package sort.stable;

import java.util.Arrays;
//插入排序要点
//1.从1到n-1遍历
//2.判断是否是已经排序(遍历元素和前一个进行比大小)
//3.没有排序则开始交换,从i开始,如果i-1大于insert,交换.
//4.把最后一位没有交换的赋值为insert.

public class InsertionSort {
    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                insertBefore(nums, i);
            }
        }
    }

    public static void insertBefore(int[] nums, int insert) {
        int tmp = nums[insert];
        int i = insert;
        while (i > 0 && nums[i - 1] > tmp) {
            nums[i] = nums[i - 1];
            i--;
        }
        nums[i] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {8, 7, 9, 5, 1, 2, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
