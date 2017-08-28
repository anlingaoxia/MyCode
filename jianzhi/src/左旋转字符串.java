package src;

public class 左旋转字符串 {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n <= 0) {
            return str;
        }
        n = n % str.length();
        char[] ctr = str.toCharArray();
        char[] tmp = new char[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = ctr[i];
        }
        for (int i = n; i < ctr.length; i++) {
            ctr[i - n] = ctr[i];
        }
        for (int i = 0; i < n; i++) {
            ctr[ctr.length - n + i] = tmp[i];
        }
        return new String(ctr);
    }
}
