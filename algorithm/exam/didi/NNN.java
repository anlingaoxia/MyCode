package didi;

import java.util.Scanner;

public class NNN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        int i1 = 0;
        int allN = 0;
        for (int i = 0; i < N; i++) {
            int i2 = function(nums, i1, i);
            if (i2 < 0) {
                continue;
            } else {
                allN++;
                i1 = i + 1;
            }
        }
        System.out.println(allN);
    }

    public static int function(int[] nums, int m, int n) {
        int q = 0;
        for (int i = n; i >= m; i--) {
            q ^= nums[i];
            if (q == 0) return i;
        }
        return -1;
    }

}
