package src;

import java.util.ArrayList;
import java.util.Arrays;

public class 字符串的排列_题目 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> all = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return all;
        }
        char[] ctr = str.toCharArray();
        Arrays.sort(ctr);

        return all;
    }

    //交换，题目不让用
    public void PermutationHelper(ArrayList<String> all, char[] ctr, int p) {
        if (p == ctr.length - 1) {
            all.add(new String(ctr));
        }

        for (int i = p; i < ctr.length; i++) {
            if (!duplicate(ctr, i)) {
                swap(ctr, i, p);
                PermutationHelper(all, ctr, p + 1);
                swap(ctr, i, p);
            }
        }
    }

    public boolean duplicate(char[] ctr, int p) {
        for (int i = p + 1; i < ctr.length; i++) {
            if (ctr[p] == ctr[i]) return true;
        }
        return false;
    }

    public void swap(char[] ctr, int i, int j) {
        char t = ctr[i];
        ctr[i] = ctr[j];
        ctr[j] = t;
    }

    //排序
    public void PermutationIterator(ArrayList<String> all, char[] ctr, int p, boolean[] used) {
        if (p == ctr.length) {
            all.add(new String(ctr));
        }
        for (int i = p; i < ctr.length; i++) {
            if (used[i] || i > p && !used[i - 1] && ctr[i - 1] == ctr[i]) {
                continue;
            }
            PermutationIterator(all, ctr, p + 1, used);
        }
    }

}
