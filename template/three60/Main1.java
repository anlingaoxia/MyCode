package three60;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        if ((x - y * b / c - z * a / d) == 0) {
            System.out.println(y * m / c + z * n / d);
        } else if ((x - y * b / c - z * a / d) > 0) {
            int i = Math.min(n / a, m / b);
            int j = (m - i * b) / c;
            int k = (n - i * a) / d;
            System.out.println(i * x + j * y + k * z);
        } else {
            int j = m / c;
            int k = n / d;
            int i = Math.min((n - k * d) / a, (m - j * c) / b);
            System.out.println(i * x + j * y + k * z);
        }
    }
}
