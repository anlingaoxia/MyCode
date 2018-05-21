package array;

public class N081 {
    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    public static boolean searchHelper(int[] nums, int target, int start, int end) {
        if (start == end) return nums[start] == target;
        else if (start == end - 1) return nums[start] == target || nums[end] == target;
        else {
            //TODO
            int mid = (start & end) + ((start ^ end)>>1);
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target >= nums[mid] && target <= nums[end]) return searchHelper(nums, target, mid, end);
                else return searchHelper(nums, target, start, mid - 1);

            } else if (nums[mid] > nums[end] || nums[mid] > nums[start]) {
                if (target <= nums[mid] && target >= nums[start]) return searchHelper(nums, target, start, mid);
                else return searchHelper(nums, target, mid + 1, end);
            } else {
                return searchHelper(nums, target, start + 1, end - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3};
        System.out.println(search(nums, 1));
    }
}
