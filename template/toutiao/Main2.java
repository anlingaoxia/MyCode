package toutiao;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        int result = 0;
        for (int loop = 1; loop <= nums.length; loop++) {
            int rlt = get(nums, loop);
            if (rlt > result) result = rlt;
        }
        System.out.print(result);
    }

    public static int get(int[] nums, int loop) {
        int sum = 0;
        int min = nums[0];
        for (int i = 0; i < loop; i++) {
            sum += nums[i];
            if (nums[i] < min) min = nums[i];
        }
        int minProduct = sum * min;
        for (int last = loop; last < nums.length; last++) {
            int total = sum - nums[last - loop] + nums[last];
            if (nums[last] < min) min = nums[last];
            if (total > sum) minProduct = sum * min;
            sum = total;
        }
        return minProduct;
    }

    public static int getResult(int[] nums, int loop, int index) {
        int min, total;
        total = 0;
        min = nums[index];
        for (int i = 0; i < loop; i++) {
            if (min >= nums[index + i]) min = nums[index + i];
            total += nums[index + i];
        }
        return total * min;
    }

}

