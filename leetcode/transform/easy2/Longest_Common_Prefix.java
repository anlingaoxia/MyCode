package transform.easy2;

public class Longest_Common_Prefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int point = 0;
        outer: for (int i = 0; i < strs[0].length(); i++) {
            char now = strs[0].charAt(i);
            for (String str : strs) {
                if (str.length() <= i) break outer;
                if (str.charAt(i) != now) break outer;
            }
            point++;
        }
        if (point > 0) {
            return strs[0].substring(0, point);
        }
        return "";

    }
    
    public static void main(String[] args) {
        String[] input = {
                "a"
        };
        System.out.println(longestCommonPrefix(input));
    }
}
