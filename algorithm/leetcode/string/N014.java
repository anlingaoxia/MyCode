package string;

public class N014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minL = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < minL) minL = s.length();
        }
        int count = 0;
        for (int i = 0; i < minL; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) return new String(strs[0].toCharArray(), 0, count);
            }
            count++;
        }
        return new String(strs[0].toCharArray(), 0, minL);
    }
}
