package src;

import java.util.ArrayList;

public class 字符串的排列Ⅱ {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> all = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return all;
        }
        PermutationHelper(str.toCharArray(), all, new char[str.length()], 0, new boolean[str.length()]);
        return all;
    }

    public void PermutationHelper(char[] ctr, ArrayList<String> all, char[] save, int sp, boolean[] used) {
        if (sp == ctr.length) {
            all.add(new String(save));
        }
        for (int i = 0; i < ctr.length; i++) {
            if (used[i] || i != 0 && !used[i - 1] && ctr[i] == ctr[i - 1]) {
                continue;
            }
            used[i] = true;
            save[sp++] = ctr[i];
            PermutationHelper(ctr, all, save, sp, used);
            sp--;
            used[i] = false;
        }
    }
}
