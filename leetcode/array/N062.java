package array;

import java.util.ArrayList;
import java.util.List;

public class N062 {
    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <=0) return 0;
        List<Integer> last = new ArrayList<>();
        last.add(1);
        return uniqueHelper(m, n, 1, last);
    }

    public static int uniqueHelper(int m, int n, int x, List<Integer> last) {
        if (m + n - 1 == x) return last.get(0);
        System.out.println(last);
        List<Integer> now = new ArrayList<>();
        int index = 0;
        for (int i = 0; i <= x; i++) {
            int r = i;
            int c = x - i;
            if (r >= m || c >= n) continue;
            if (r == 0) now.add(last.get(0));
            else if (c == 0) now.add(last.get(last.size() - 1));
            else now.add(last.get(index) + last.get(index++ + 1));
        }
        return uniqueHelper(m, n, x + 1, now);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(4, 4));
    }


}
