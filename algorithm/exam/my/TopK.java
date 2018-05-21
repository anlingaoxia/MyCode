package my;

import java.util.Scanner;

public class TopK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        System.out.println(TheK(nums, K));
    }

    public static int TheK(int[] nums, int K) {
        int i = 0, j = nums.length - 1;
        int index = K + 1;
        while (index != K) {
            index = sortOnce(nums, i, j);
            if (index > K) {
                j = index - 1;
            } else {
                i = index + 1;
            }
        }
        return nums[index];
    }

    public static int sortOnce(int[] nums, int i, int j) {
        int key = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= key) {
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


}
