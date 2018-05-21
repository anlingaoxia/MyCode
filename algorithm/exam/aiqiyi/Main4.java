package aiqiyi;

import java.util.HashSet;

public class Main4 {
    public static int get(int m, int n) {
        int max = m * n;
        int mSqrt = (int) Math.floor(Math.sqrt(max));
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= mSqrt; i++) {
            set.add(i * i);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (set.contains(i * j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(get(4, 8));
    }

}
