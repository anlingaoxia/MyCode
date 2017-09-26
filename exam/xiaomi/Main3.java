package xiaomi;

import java.util.Arrays;

public class Main3 {
    static int fun(String drinks, int n) {
        char[] ctr = drinks.toCharArray();
        return helper(ctr, n);
    }
    public static int helper(char[] ctr, int n) {
        int[] tHash = new int[26];
        for (char t : ctr) {
            tHash[t - 65]++;
        }
        Arrays.sort(tHash);
        int count;
        int same = 1;
        for (int i = 24; i >= 0; i--) {
            if (tHash[i] == tHash[25]) same++;
        }
        count = (tHash[25] - 1) * (n + 1) + same;
        return count > ctr.length ? count : ctr.length;
    }

}
