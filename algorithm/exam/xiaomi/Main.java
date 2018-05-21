package xiaomi;

import java.util.Arrays;

public class Main {
    static boolean fun(String table, int n) {
        if (table == null || table.length() == 0) {
            return 0 >= n;
        }
        char[] ctr = table.toCharArray();
        boolean pre = helper(ctr, n);
        for (int i = 0, j = ctr.length - 1; i < j; i++, j--) {
            char t = ctr[i];
            ctr[i] = ctr[j];
            ctr[j] = t;
        }
        boolean post = helper(ctr, n);
        return pre || post;
    }

    static boolean helper(char[] ctr, int n) {
        int count = 0;
        if (ctr.length == 1) {
            count = ctr[0] == 0 ? 1 : 0;
            return count >= n;
        } else if (ctr.length == 2) {
            count = ctr[0] == ctr[1] && ctr[0] == 0 ? 1 : 0;
            return count >= n;
        }
        if (ctr[0] == 0 && ctr[1] == 0) {
            ctr[0] = '1';
            count++;
        }
        for (int i = 1; i < ctr.length - 1; i++) {
            if (check(ctr, i)) {
                ctr[i] = '1';
                count++;
            }
        }
        if (ctr[ctr.length - 2] == 0 && ctr[ctr.length - 1] == 0) {
            ctr[ctr.length - 1] = '1';
            count++;
        }
        return count >= n;
    }

    static boolean check(char[] ctr, int i) {
        if (ctr[i - 1] == '0' && ctr[i] == '0' && ctr[i + 1] == '0') return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(fun("111100", 1));
//        System.out.println(fun("10001", 1));
//        System.out.println(fun("10001", 2));
    }
}
