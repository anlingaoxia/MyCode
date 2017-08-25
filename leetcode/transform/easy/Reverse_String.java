package transform.easy;

public class Reverse_String {
    // 3ms
    public static String reverseString1(String s) {
        int length = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
        }
        return String.valueOf(cs);
    }

    public static String reverseString2(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            System.out.println("i:" + (byte)word[i] + "\t" + "j:" + (byte)word[j]);
            word[i] = (char) (word[i] ^ word[j]);
            System.out.println("i:" + (byte)word[i] + "\t" + "j:" + (byte)word[j]);
            word[j] = (char) (word[i] ^ word[j]);
            System.out.println("i:" + (byte)word[i] + "\t" + "j:" + (byte)word[j]);
            word[i] = (char) (word[i] ^ word[j]);
            System.out.println("i:" + (byte)word[i] + "\t" + "j:" + (byte)word[j]);
            i++;
            j--;
            System.out.println();
        }
        return new String(word);
    }

    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(reverseString2(s));
    }
}
