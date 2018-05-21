package xiaomi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
/*    public static List<Integer> getRow(int rowIndex, int target) {
        Integer[] row = new Integer[rowIndex + 1];
        Arrays.fill(row, 0);
        row[0] = 1;
        for (int i = 1; i < row.length; i++) {
            for (int j = i; j >= 1; j--) {
                row[j] += row[j - 1];
            }
        }
        return Arrays.asList(row);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allList = new ArrayList<>();
        if (numRows < 1) return allList;
        List<Integer> next = new ArrayList<>();
        next.add(1);
        allList.add(next);
        for (int i = 2; i <= numRows; i++) {
            next = getNextRow(next);
            allList.add(next);
        }
        return allList;
    }*/

    public static int[] isInRow(int[] last, long target) {
        int[] row = new int[last.length + 1];
        row[0] = row[row.length - 1] = 1;
        for (int i = 1; i < row.length - 1; i++) {
            row[i] = last[i] + last[i - 1];
            if (row[i] == target) return null;
        }
        return row;
    }

    static long fun(long x) {
        if (x == 1) return 1;
        int depth = 1;
        int[] last = {1};
        while (last != null) {
            last = isInRow(last, x);
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        System.out.println(fun(1));
        System.out.println(fun(4));
        System.out.println(fun(10));
    }
}
