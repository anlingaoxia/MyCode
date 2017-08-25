package transform.medium;

import java.util.Arrays;

public class Search_For_A_Range {
    // 8ms
    public int[] searchRange1(int[] nums, int target) {
        int[] result = { 0, 0 };
        for (; result[0] < nums.length; result[0]++) {
            if (nums[result[0]] == target) {
                result[1] = result[0];
                for (int i = result[1] + 1; i < nums.length; i++) {
                    if (nums[i] == target) {
                        result[1] = i;
                    } else {
                        break;
                    }
                }
                return result;
            }
        }
        return new int[] { -1, -1 };
    }

    // 7ms
    public int[] searchRange2(int[] nums, int target) {
        int[] result = { -1, -1 };
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = result[1] = i;
                for (i++; i < nums.length; i++) {
                    if (nums[i] == target) {
                        result[1] = i;
                    } else {
                        break;
                    }
                }
                return result;
            }
        }
        return result;
    }

    // 8ms
    public static int[] searchRange3(int[] nums, int target) {
        int[] result = { -1, -1 };
        int position = Arrays.binarySearch(nums, target);
        if (position >= 0) {
            result[0] = result[1] = position;
            for (int i = position - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    result[0] = i;
                } else {
                    break;
                }
            }

            for (int j = position + 1; j < nums.length; j++) {
                if (nums[j] == target) {
                    result[1] = j;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    // 7ms
    // ��������������߽���ұ߽�
    public static int[] searchRange4(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] result = { -1, -1 };
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target) i = mid + 1;
            else j = mid;
        }
        if (nums[i] != target) return result;
        else result[0] = i;

        j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2 + 1;
            if (nums[mid] > target) j = mid - 1;
            else i = mid;
        }
        result[1] = j;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2 };
        int target = 3;
        int i = Arrays.binarySearch(nums, target);
        System.out.println(i);
        System.out.println(Arrays.toString(searchRange3(nums, target)));
    }
}