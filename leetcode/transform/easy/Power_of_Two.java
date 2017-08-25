package transform.easy;

public class Power_of_Two {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        while (n > 1) {
            if ((n & 1) == 1) {
                return false;
            } else {
                n >>= 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));

    }
}
