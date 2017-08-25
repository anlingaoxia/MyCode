package transform.medium;

import java.util.Arrays;

public class Counting_Bits {
    public static int[] countBits(int num) {
        if (num < 1) return new int[] { 0 };
        int[] res = new int[num + 1];
        int[] increment = new int[num + 1];
        increment[0] = 0;
        res[0] = 0;
        int width = 0;
        int count = 1;
        while (true) {
            width++;
            res[count] = res[count - 1] + 2 - width;
            increment[count++] = 2 - width;
            int temp = (int) Math.min(Math.pow(2, width - 1) - 1, num + 1 - count);
            for (int j = 1; j <= temp; j++) {
                res[count] = res[count - 1] + increment[j];
                increment[count++] = increment[j];
            }
            if (count > num) break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }
}
