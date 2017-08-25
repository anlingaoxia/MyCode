package transform.medium;

public class Integer_Break {
    public static int integerBreak(int n) {
        if (n < 4) return n - 1;
        return get(n);
    }

    public static int get(int n) {
        int total = 1;
        while (n > 3) {
            total = total * 3;
            n -= 3;
        }
        if (n > 1) total *= n;
        if (n == 1) total = total / 3 * 4;
        return total;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(6));
    }
}
