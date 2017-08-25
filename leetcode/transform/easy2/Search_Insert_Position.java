package transform.easy2;

public class Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        } else if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        return get(0, nums.length - 1, nums, target);
    }

    public int get(int start, int end, int[] nums, int target) {
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[start] > target) {
            return -1;
        } else if (nums[end] < target) {
            return -2;
        }
        int left = get(start, mid, nums, target);
        int right = get(mid + 1, end, nums, target);
        if (left >= 0) {
            return left;
        }
        if (right >= 0) {
            return right;
        } else {
            return nums[mid] < target ? mid + 1 : mid - 1;
        }

    }

}
