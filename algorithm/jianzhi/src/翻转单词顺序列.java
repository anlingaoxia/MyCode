package src;

public class 翻转单词顺序列 {
    public String ReverseSentence(String str) {
        char[] ctr = str.toCharArray();
        reverse(ctr, 0, ctr.length - 1);
        int start = -1, end = -1;
        for (int i = 0; i < ctr.length; i++) {
            if (start < 0 && ctr[i] != ' ') {
                start = end = i;
            } else if (start >= 0 && ctr[i] != ' ') {
                end = i;
            } else if (ctr[i] == ' ' && start >= 0) {
                reverse(ctr, start, end);
                start = end = -1;
            }
        }
        if (start >= 0) {
            reverse(ctr, start, end);
        }
        return new String(ctr);
    }

    public void reverse(char[] ctr, int start, int end) {
        for (; start < end; start++, end--) {
            char t = ctr[start];
            ctr[start] = ctr[end];
            ctr[end] = t;
        }
    }
}
