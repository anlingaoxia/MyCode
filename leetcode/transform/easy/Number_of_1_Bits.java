package transform.easy;

public class Number_of_1_Bits {
    public static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 49) {
                count++;
            }
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        int count = 0;
        for (int i = 0; i < 31; i++) {
            if (n > (n ^ (1 << i))) {
                count++;
            }
        }
        if ((n ^ (1 << 31)) >= 0) {
            count++;
        }

        return count;
    }

    public static int hammingWeight3(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "10000000000000000000000000000000";
        int a = 2147483647;
        int b = a + 1;
        int c = b + 1;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println(hammingWeight3(b + 1));
        // System.out.println(hammingWeight2(b));

        // int count = 0;
        // for (int i = 0; i < s.length(); i++) {
        // if (s.charAt(i) == '0') {
        // count++;
        // }
        // }
        // System.out.println(count);
    }
}
