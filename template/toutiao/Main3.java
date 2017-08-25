package toutiao;

import java.util.Scanner;

/**
 * Created by lik on 17-8-22.
 */
public class Main3 {
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
            for (int index = 0; index <= nums.length - loop; index++) {
                int temp = getResult(nums, loop, index);
                result = result <= temp ? temp : result;
            }
        }
        System.out.print(result);
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
