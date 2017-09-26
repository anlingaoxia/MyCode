package haoweilai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        pop(N, 3);
    }

    public static void pop(int N, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int k = 0;
        while (!list.isEmpty()) {
            k = (k + n) % (list.size()) - 1;
            if (k < 0) {
                System.out.println(list.remove(list.size() - 1));
                k = 0;
            } else {
                System.out.println(list.remove(k));
            }
        }
    }
}
