package sort.unstable;

public class QuickSort {
    //快速排序不需要swap
    public static void sort(int[] nums, int i, int j) {
        if (i >= j) return;
        int k = sortOnce(nums, i, j);
        sort(nums, i, k - 1);
        sort(nums, k + 1, j);
    }

    public static int sortOnce(int[] nums, int i, int j) {
        int key = nums[i];
        while (i < j) {
            while (i < j && nums[j] > key) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
            }
            while (i < j && nums[i] < key) {
                i++;
            }

            if (i < j) {
                nums[j] = nums[i];
            }
        }
        nums[i] = key;
        return i;
    }

    public static void main(String[] args) {

    }

}
