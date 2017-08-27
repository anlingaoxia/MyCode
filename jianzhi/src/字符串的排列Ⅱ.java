package src;

import java.util.ArrayList;
import java.util.List;

public class 字符串的排列Ⅱ {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        char[] ctr = str.toCharArray();
        boolean[] alphabet = new boolean[128];
        PermutationHelper(ctr, list, 0, alphabet);
        return list;
    }

    public static void PermutationHelper(char[] ctr, List<String> list, int p, boolean[] alphabet) {
        if (p == ctr.length - 1) {
            list.add(new String(ctr));
        }
        for (int i = p; i < ctr.length; i++) {
            if (i != p && ctr[i] == ctr[p]) {
                continue;
            }
            swap(ctr, p, i);
            PermutationHelper(ctr, list, p + 1, alphabet);
            swap(ctr, p, i);
        }
        System.out.println();
    }

    public static void swap(char[] ctr, int i, int j) {
        char t = ctr[i];
        ctr[i] = ctr[j];
        ctr[j] = t;
    }

    public static void main(String[] args) {
        String str = "aabc";
        System.out.println(Permutation(str));
    }


}
