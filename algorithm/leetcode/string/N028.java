package string;

public class N028 {
    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (haystack.equals("")) return -1;
        if (haystack.length() < needle.length()) return -1;
        char[] ch = haystack.toCharArray();
        char[] cn = needle.toCharArray();
        for (int i = 0; i <= ch.length - cn.length; i++) {
            boolean has = true;
            for (int j = 0; j <= cn.length - 1; j++) {
                if (ch[i + j] != cn[j]) has = false;
            }
            if (has) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "mississippi";
        String b = "issi";
        System.out.println(strStr(a, b));
    }
}
