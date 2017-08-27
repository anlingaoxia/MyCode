package src;

public class 斐波那契数列 {
    public int Fibonacci(int n) {
        int n1 = 1;
        int n2 = 1;
        if (n < 1) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        int n3 = 0;
        for (int i = 0; i < n - 2; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }
}
