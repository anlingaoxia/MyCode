package src;

public class 第一个只出现一次的字符位置 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[][] bucket = new int[128][2];
        for (int i = 0; i < str.length(); i++) {
            bucket[str.charAt(i)][0]++;
            bucket[str.charAt(i)][1] = (char) i;
        }
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < 128; i++) {
            if (bucket[i][0] == 1 && bucket[i][1] < index) {
                index = bucket[i][1];
            }
        }
        return index;
    }
}
