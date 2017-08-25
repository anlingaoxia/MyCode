package string;

public class N459 {
    public static boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() == 0) return false;
        int maxL = str.length() / 2;
        for (int i = 1; i <= maxL; i++) {
            if (str.length() % i == 0 && check(str, i)) return true;
        }
        return false;
    }

    public static boolean check(String s, int k) {
        System.out.println("k: " + k);
        for (int i = k; i < s.length(); i = i + k) {
            for (int j = i, c = 0; j < i + k; j++, c++) {
                if (s.charAt(c) != s.charAt(j)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abab";
        System.out.println(repeatedSubstringPattern(str));
    }

}
