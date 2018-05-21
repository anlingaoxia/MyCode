package threesixzero;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), aSum = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            aSum += a[i];
        }
        int m = sc.nextInt(), bSum = 0;
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            bSum += b[i];
        }

        balance(a, b, aSum, bSum);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Math.abs(aSum - bSum));
    }

    public static void balance(int[] a, int[] b, int aSum, int bSum) {
        System.out.println(aSum + "+" + bSum);
        int diff = aSum - bSum;
        System.out.println("diff:" + diff);
        while (diff != 0) {
            int aMin = 0, bMin = 0, best = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    if (Math.abs(diff - 2 * (a[i] - b[j])) < Math.abs(diff - 2 * best)) {
                        best = a[i] - b[j];
                        aMin = i;
                        bMin = j;
                    }
                }
            }
            if (best == 0) {
                return;
            }
            swap(a, b, aMin, bMin);
            aSum -= best;
            bSum += best;
            diff = aSum - bSum;
        }
    }


    public static void swap(int[] a, int[] b, int ai, int bj) {
        int t = a[ai];
        a[ai] = b[bj];
        b[bj] = t;
    }



}
