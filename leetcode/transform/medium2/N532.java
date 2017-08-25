package transform.medium2;

import java.util.Arrays;

public class N532 {
    public static int findPairs(int[] nums, int k) {
        if (nums.length < 2 || nums == null) return 0;
        Arrays.sort(nums);
        int count = 0;
        int index = 0;
        int last = nums[0] - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == last) continue;
            int target = k + nums[i];
            int p = binarySearch(nums, Math.max(index, i) + 1, nums.length - 1, target);
            if (p != -1) {
                count++;
                index = p;
            }
            last = nums[i];
        }
        return count;
    }

    public static int binarySearch(int[] array, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) return mid;
            else if (array[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { -1, 0, 1, 1, 1, 2 };
        // System.out.println(binarySearch(array, 0, 4, 2));
        System.out.println(findPairs(array, 1));
    }
}
