package transform.easy;

import java.util.Arrays;

public class Assign_Cookies {
    // 18ms
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int lasts = s.length - 1;
        int lastg = g.length - 1;
        int count = 0;

        for (int i = lasts; i >= 0; i--) {
            for (int j = lastg; j >= 0; j--) {
                if (s[i] >= g[j]) {
                    lastg = j - 1;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = { 10, 9, 8, 7 };
        int[] s = { 5, 6, 7, 8 };
        System.out.println(findContentChildren(g, s));

    }
}
