package haoweilai;

import java.util.Iterator;
import java.util.LinkedList;

public class Main3 {
    public static void main(String[] args) {
        int N = 7;
        int[] arr = new int[N];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
            arr[i] = i + 1;
        }
//        pop(arr, 2);
        pop(list, 10000);
    }

    public static void pop(int[] arr, int N) {
        boolean[] use = new boolean[arr.length];
        int i = 0, c = 0, l = 0, n = N;
        while (l != arr.length) {
            if (!use[i] && ++c == N) {
                System.out.println(arr[i]);
                use[i] = true;
                c = 0;
                if (++l != arr.length) n = n % (arr.length - l);
            }
            if (++i == arr.length) i = 0;
        }
    }
    public static void pop(LinkedList<Integer> list, int N) {
        int c = 0;
        if ((N = N % list.size()) == 0) N = list.size();
        Iterator<Integer> iter = list.iterator();
        while (!list.isEmpty()) {
            int t = iter.next();
            if (++c == N) {
                c = 0;
                iter.remove();
                System.out.println(t);
                if (!list.isEmpty() && (N = N % list.size()) == 0) N = list.size();
            }
            if (!iter.hasNext()) {
                iter = list.iterator();
            }
        }
    }


}
