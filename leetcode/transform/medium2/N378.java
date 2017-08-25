package transform.medium2;

import java.util.Arrays;

public class N378 {
    public static int kthSmallest(int[][] matrix, int k) {
        return get(matrix, 1, k);
    }

    public static int get(int[][] mat, int n, int k) {
        if (n * n == k) return mat[n - 1][n - 1];
        else if (n * n < k) return get(mat, n + 1, k);
        int start = (n - 1) * (n - 1) + 1;
        int row = 0;
        int col = 0;
        for (int c = start; c <= k; c++) {
            if (mat[row][n - 1] <= mat[n - 1][col]) row++;
            else if (mat[row][n - 1] > mat[n - 1][col]) col++;
        }
        if (row == 0) return mat[n - 1][col - 1];
        else if (col == 0) return mat[row - 1][n - 1];
        return Math.max(mat[row - 1][n - 1], mat[n - 1][col - 1]);
    }

    public static int get2(int[][] mat, int k) {
        int[] save = new int[mat.length];
        int count = mat.length * mat.length;
        

        return 0;
    }

    public static int getBelow(int[][] mat, int start, int[] save) {
        int count = 0;
        int n = mat.length;
        for (int i = n - 1; i >= 0; i--) {
            int p = save[i];
            while (p >= 0 && mat[p][i] > start) {
                p--;
            }
            save[i] = p;
            count += p + 1;
        }
        return count;
    }

    public static int getAbove(int[][] mat, int start, int[] save) {
        int count = 0;
        int n = mat.length;
        for (int i = n - 1; i >= 0; i--) {
            int p = save[i];
            while (p < n && mat[p][i] < start) {
                p++;
            }
            save[i] = p;
            count += (n - p);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 3, 5 }, { 6, 7, 12 }, { 11, 14, 14 } };
        int[] save = { 2, 1, 0 };
        int count = getAbove(mat, 3, save);
        System.out.println(count);
        System.out.println(Arrays.toString(save));
        
    }

}
