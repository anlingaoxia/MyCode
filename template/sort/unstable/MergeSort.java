package sort.unstable;

import java.util.Arrays;

//归并排序要点:
//1.一次排序是按照两段index来进行排序的,不是有两个新的int[]来排序的,只有一个新的Array生成.
//2.对于每次sort,先sort左边,再sort右边,最后sortOnce
public class MergeSort {
    public static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        sortOnce(nums, start, mid, end);
    }

    public static void sortOnce(int[] nums, int start, int mid, int end) {
        int[] newArray = new int[end - start + 1];
        int index = 0, index1 = start, index2 = mid + 1;
        while (index1 <= mid || index2 <= end) {
            if (index2 > end || index1 <=mid && nums[index1] <= nums[index2]) {
                newArray[index++] = nums[index1++];
            } else {
                newArray[index++] = nums[index2++];
            }
        }
        System.arraycopy(newArray, 0, nums, start, end + 1 - start);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 0};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }


}
