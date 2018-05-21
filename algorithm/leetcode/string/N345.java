package string;

import java.util.ArrayList;
import java.util.List;

public class N345 {
    public String reverseVowels(String s) {
        List<Integer> sites = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (checkVowel(s.charAt(i))) sites.add(i);
        }
        char[] cs = s.toCharArray();
        for (int i = 0, j = sites.size() - 1; i < j; i++, j--) {
            char t = cs[sites.get(i)];
            cs[sites.get(i)] = cs[sites.get(j)];
            cs[sites.get(j)] = t;
        }
        return new String(cs);
    }

    public boolean checkVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
