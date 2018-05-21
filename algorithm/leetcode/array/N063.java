package array;

public class N063 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0)
            return 0;
        int[][] record = new int[obstacleGrid.length][obstacleGrid[0].length];
        record[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        return uniqueHelper(obstacleGrid, record, 1);
    }

    public static int uniqueHelper(int[][] obstacleGrid, int[][] record, int n) {
        if (obstacleGrid.length + obstacleGrid[0].length - 2 < n)
            return record[record.length - 1][record[0].length - 1];
        for (int i = 0; i <= n; i++) {
            int r = i;
            int c = n - i;
            if (r >= obstacleGrid.length || c >= obstacleGrid[0].length) continue;
            if (obstacleGrid[r][c] == 1) record[r][c] = 0;
            else if (r == 0) record[r][c] = record[r][c - 1];
            else if (c == 0) record[r][c] = record[r - 1][c];
            else record[r][c] = record[r][c - 1] + record[r - 1][c];
        }
        return uniqueHelper(obstacleGrid, record, n + 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0}};
        System.out.println(uniquePathsWithObstacles(grid));


    }

}
