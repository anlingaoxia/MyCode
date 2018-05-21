package array;

import java.util.ArrayList;
import java.util.List;

public class N064 {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        List<Integer> last = new ArrayList<>();
        last.add(grid[0][0]);
        List<Integer> end = minHelper(grid, 1, last);
        return end.get(0);
    }

    public static List<Integer> minHelper(int[][] grid, int n, List<Integer> last) {
        if (grid.length + grid[0].length - 1 == n) return last;
        List<Integer> now = new ArrayList<>();
        int index = 0;
        for (int i = 0; i <= n; i++) {
            int r = i;
            int c = n - i;
            if (r >= grid.length || c >= grid[0].length) continue;
            if (r == 0) now.add(last.get(0) + grid[r][c]);
            else if (c == 0) now.add(last.get(last.size() - 1) + grid[r][c]);
            else {
                now.add(Math.min(last.get(index) + grid[r][c], last.get(index++ + 1) + grid[r][c]));
            }
        }
        return minHelper(grid, n + 1, now);
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {1, 0, 2}, {1, 3, 1}};
        System.out.println(minPathSum(array));
    }

}
