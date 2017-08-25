package transform.easy;

import java.math.BigDecimal;

public class Climbing_Stairs {
    public static int climbStairs(int n) {
        int two = n / 2;
        int one = n % 2;
        int count = 0;
        for (int i = 0; i <= two; i++) {
            int m = two + i + one;
            int k = i * 2 + one;
            int temp = countMult(m, k);
            count += temp;
        }
        return count;
    }

    public static int countMult(int n, int k) {
        BigDecimal up = BigDecimal.valueOf(1);
        BigDecimal down1 = BigDecimal.valueOf(1);
        BigDecimal down2 = BigDecimal.valueOf(1);

        for (int i = 1; i <= n; i++) {
            BigDecimal temp = BigDecimal.valueOf(i);
            up = up.multiply(temp);
            if (i <= k) {
                down1 = down1.multiply(temp);
            }
            if (i <= n - k) {
                down2 = down2.multiply(temp);
            }
        }

        return (up.divide((down1.multiply(down2)))).intValue();
    }

    public static int get(int n) {
        int a = 1, b = 1;
        while (n-- > 0)
            a = (b += a) - a;
        return a;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }

}
