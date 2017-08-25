package transform.easy2;

public class Implement_strStr {
    public static int strStr(String haystack, String needle) {
        if (haystack.equals("") && needle.equals("")) {
            return 0;
        } else if (haystack.equals("") || needle.equals("")) {
            return -1;
        }

        char[] cH = haystack.toCharArray();
        char[] nH = needle.toCharArray();

        outer: for (int i = 0; i <= cH.length - nH.length; i++) {
            for (int j = 0; j < nH.length; j++) {
                if (cH[i + j] != nH[j]) {
                    continue outer;
                }
            }
            return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "123456";
        String needle = "3456";
        System.out.println(strStr(haystack, needle));
    }

}
