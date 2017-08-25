package transform.easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valid_Anagram {
    public static boolean isAnagram1(String s, String t) {
        String regex = t;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean isAnagram2(String s, String t) {
        int sHash[] = new int[123];
        int tHash[] = new int[123];
        for(int i = 0; i < s.length(); i++) {
            sHash[s.charAt(i)]++;
        }
        for(int i = 0; i < t.length(); i++) {
            tHash[t.charAt(i)]++;
        }
        
        boolean res = true;
        for(int i = 0; i < 123; i++) {
            if(tHash[i] != sHash[i]) {
                res = false;
            }
        }
       return res; 
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "ba";
        System.out.println(isAnagram2(s, t));
    }
}
