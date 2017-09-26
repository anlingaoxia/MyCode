package src;

public class 丑数 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] nums = new int[index];
        nums[0] = 1;
        int p = 1, ugly2 = 0, ugly3 = 0, ugly5 = 0;
        while (p < index) {
            int min = min(nums[ugly2] * 2, nums[ugly3] * 3, nums[ugly5] * 5);
            nums[p++] = min;
            while (nums[ugly2] * 2 <= min) {
                ugly2++;
            }
            while (nums[ugly3] * 3 <= min) {
                ugly3++;
            }
            while (nums[ugly5] * 5 <= min) {
                ugly5++;
            }
        }
        return nums[nums.length - 1];
    }

    public int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
