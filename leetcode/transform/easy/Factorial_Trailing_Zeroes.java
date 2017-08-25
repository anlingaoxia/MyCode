package transform.easy;

public class Factorial_Trailing_Zeroes {
    public static int trailingZeroes(int n) {
        int five = 1;
        int count = 0;
        while (n >= Math.pow(5, five)) {
            int current = (int) (n / Math.pow(5, five));
            count += current;
            five++;
        }
        return count;
    }

    public static void main(String[] args) {
        // BigInteger count = BigInteger.valueOf(1);
        // for (int i = 1; i <= 50; i++) {
        // count = count.multiply(BigInteger.valueOf(i));
        // System.out.println(i + " " + count);
        // }
        System.out.println(trailingZeroes(2147483647));

    }

}
