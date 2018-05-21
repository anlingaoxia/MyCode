package string;

public class N541 {
    public static String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) return "";
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i = i + 2*k) {
            int start = i;
            int end = i + k -1;
            if (end >= cs.length) end = cs.length - 1;
            reverse(cs, start, end);
        }
        return new String(cs);
    }

    public static void reverse(char[] cs, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char t = cs[i];
            cs[i] = cs[j];
            cs[j] = t;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseStr(s, 2));
    }


}
