package array;

public class N033 {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            System.out.println(start + "  " + end);
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[start] || nums[mid] < nums[end]) {
                if (target > nums[mid] && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                start++;
                end--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1 , 3};
        System.out.println(search(array, 2));
    }
}
