package sort.stable;

public class BubbleSort {
    public void sort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i++) {
            boolean hasSorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    hasSorted = false;
                }
            }
            if (hasSorted) break;
        }
    }
}