package didi;

import java.util.Scanner;

public class TheMaxK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int K = sc.nextInt();
        String[] strs = line.split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(sort(nums, K));
    }

    public static int sort(int[] nums, int K) {
        for (int last = nums.length - 1; last >= nums.length - K; last--) {
            sortOnce(nums, last);
            swap(nums, 0, last);
        }
        return nums[nums.length - K];
    }

    public static void sortOnce(int[] nums, int last) {
        for (int f = (last - 1) / 2; f >= 0; f--) {
            sortSubOnce(nums, f, 2 * f + 1, last);
        }
    }

    public static void sortSubOnce(int[] nums, int f, int c, int last) {
        while (c <= last) {
            if (c < last && nums[c] < nums[c + 1]) {
                c++;
            }
            if (nums[c] > nums[f]) {
                swap(nums, c, f);
                f = c;
                c = 2 * f + 1;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
