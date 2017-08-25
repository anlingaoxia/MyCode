package transform.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_All_Anagrams_in_a_String {
    public static List<Integer> findAnagrams2(String s, String p) {
        // 26ms
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }
        int[] pHash = new int[26];
        int[] tHash = new int[26];
        int[] minus = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pHash[p.charAt(i) - 97]++;
            tHash[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < 26; i++) {
            minus[i] = pHash[i] - tHash[i];
        }
        for (int i = 0, j = p.length(); j <= s.length(); i++, j++) {
            boolean add = true;
            System.out.println(i + "   " + j);
            System.out.println(Arrays.toString(minus));
            for (int k = 0; k < 26; k++) {
                if (minus[k] != 0) {
                    add = false;
                    break;
                }
            }
            if (j < s.length()) {
                minus[s.charAt(j) - 97]--;
                minus[s.charAt(i) - 97]++;
            }
            if (add) list.add(i);
        }

        return list;

        //
        // tag: for (int i = 0; i <= s.length() - p.length(); i++) {
        // if (pHash[s.charAt(i) - 97] == 0) {
        // continue;
        // }
        // for (int j = 0; j < p.length(); j++) {
        // tHash[s.charAt(i + j) - 97]++;
        // }
        // for (int j = 0; j < 26; j++) {
        // if (pHash[j] != tHash[j]) {
        // continue tag;
        // }
        // }
        // list.add(i);
        // }
    }

    public static List<Integer> findAnagrams(String s, String p) {

        return null;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams2("baa", "aa"));

    }
}
