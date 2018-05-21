package string;

import java.util.Map;

public class N005 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() == 1) return s;
        if (s.length() == 2) return s.charAt(0) == s.charAt(1) ? s : s.substring(0, 1);
        String longest = s.substring(0, 1);
        int length = 1;
        for (int i = 1; i < s.length(); i++) {
            int l1 = checkGap(s, i);
            int l2 = checkNum(s, i);
            int lm = Math.max(l1 * 2, l2 * 2 + 1);
            if (lm > length) {
                if (lm == l1 * 2) {
                    longest = s.substring(i - l1, i + l1);
                }
            }
            length = lm;


            if (l1 * 2 > length) {
                longest = s.substring(i - l1, i + l1);
                length = l1 * 2;
            }
            if (l2 * 2 + 1 > length) {
                longest = s.substring(i - l2, i + l2 + 1);
                length = l2 * 2 + 1;
            }
        }
        return longest;
    }

    public static int checkGap(String str, int index) {
        int count = 0;
        for (int i = index - 1, j = index; i >= 0 && j < str.length(); i--, j++) {
            if (str.charAt(i) == str.charAt(j)) count++;
            else break;
        }
        return count;
    }

    public static int checkNum(String str, int index) {
        int count = 0;
        for (int i = index - 1, j = index + 1; i >= 0 && j < str.length(); i--, j++) {
            if (str.charAt(i) == str.charAt(j)) count++;
            else break;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }

}
