package 算法题;

import java.util.Iterator;
import java.util.LinkedList;

public class 约瑟夫 {
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
