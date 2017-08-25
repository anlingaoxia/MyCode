package transform.easy;

public class Hamming_Distance {
    public static int hammingDistance(int x, int y) {
        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);
        int length1 = s1.length();
        int length2 = s2.length();
        int length = Math.max(length1, length2);
        for (int i = 0; i < length - length1; i++) {
            s1 = "0" + s1;
        }
        for (int i = 0; i < length - length2; i++) {
            s2 = "0" + s2;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

}
