package transform.easy3;

public class N35 {
    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        int mid = 0;
        while (start < end) {
            mid = (start + end) >>> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid;
            else start = mid + 1;
        }
        
        return target == nums[start] ? start : target < nums[start] ? start : start + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3 };
        System.out.println(searchInsert(nums, 2));
    }

}
