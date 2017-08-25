package transform.easy;

import java.util.Arrays;

public class Majority_Element {
    // wrong
    public static int majorityElement(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        int[] nums2 = new int[max - min + 1];

        for (int i : nums) {
            nums2[i - min]++;
        }
        int n = nums.length / 2;
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] > n) {
                return i + min;
            }
        }
        return -1;
    }

    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2;
        int last = nums[0];
        for (int i = 1, j; i < nums.length;) {
            if (nums[i] == last) {
                int count = 1;
                for (j = i; j < nums.length; j++) {
                    if (nums[j] == last) {
                        if (++count > n) {
                            return nums[j];
                        }
                    } else {
                        break;
                    }
                }
                i = j;
            } else {
                last = nums[i];
                i++;
            }
        }
        return nums[0];
    }

    public static int majorityElement3(int[] nums) {
        int elem = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                elem = nums[i];
                count = 1;
            } else {
                if (elem == nums[i]) count++;
                else count--;
            }

        }
        return elem;
    }

    public static void main(String[] args) {
        int[] nums = { 1,1,2,1 };
        System.out.println(majorityElement3(nums));
    }
}