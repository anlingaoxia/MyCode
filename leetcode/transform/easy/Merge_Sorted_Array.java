package transform.easy;

import java.util.Arrays;

public class Merge_Sorted_Array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp1 = m - 1;
        int temp2 = n - 1;
        for (int i = m + n - 1; i >= 0 && temp1 >= 0 && temp2 >= 0; i--) {
            if (nums1[temp1] > nums2[temp2]) {
                nums1[i] = nums1[temp1];
                temp1--;
            } else {
                nums1[i] = nums2[temp2];
                temp2--;
            }
        }
        if (temp1 < 0) {
            for (int i = temp2; i >= 0; i--) {
                nums1[i] = nums2[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 5, 6, 0, 0, 0 };
        int[] nums2 = { 1, 2, 3 };
        merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));

    }

}
