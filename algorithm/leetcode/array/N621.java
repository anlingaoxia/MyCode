package array;

import java.util.Arrays;

public class N621 {
    public int leastInterval(char[] tasks, int n) {
        int[] tHash = new int[26];
        for (char t : tasks) {
            tHash[t - 65]++;
        }
        Arrays.sort(tHash);
        int count = 0;
        int same = 1;
        for (int i = 24; i >= 0; i--) {
            if (tHash[i] == tHash[25]) same++;
        }
        count = (tHash[25] - 1) * (n + 1) + same;
        return count > tasks.length ? count : tasks.length;
    }

    public static void main(String[] args) {
    }
}
