package array;

public class N034 {
    public int[] searchRange(int[] nums, int target) {
        int index = find(nums, target);
        if (index == -1) return new int[]{-1, -1};
        return new int[]{findLeft(nums, target, index), findRight(nums, target, index)};
    }

    public int find(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) return mid;
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public int findLeft(int[] nums, int target, int index) {
        int start = 0;
        int end = index - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                if (mid == 0) return 0;
                else if (nums[mid] == nums[mid - 1]) end = mid - 1;
                else return mid;
            } else start = mid + 1;
        }
        return index;
    }

    public int findRight(int[] nums, int target, int index) {
        int start = index + 1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1) return nums.length - 1;
                else if (nums[mid] == nums[mid + 1]) start = mid + 1;
                else return mid;
            } else end = mid - 1;
        }
        return index;
    }


//    public int[] searchRange(int[] nums, int target) {
//        int i = 0, j = nums.length - 1;
//        int[] result = { -1, -1 };
//        while (i < j) {
//            int mid = (i + j) / 2;
//            if (nums[mid] < target) i = mid + 1;
//            else j = mid;
//        }
//        if (nums[i] != target) return result;
//        else result[0] = i;
//
//        j = nums.length - 1;
//        while (i < j) {
//            int mid = (i + j) / 2 + 1;
//            if (nums[mid] > target) j = mid - 1;
//            else i = mid;
//        }
//        result[1] = j;
//        return result;
//    }


}
