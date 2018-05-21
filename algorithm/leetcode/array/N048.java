package array;

import java.util.Arrays;

public class N048 {
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int N = matrix.length - 1;
        int range = N / 2;
        for (int i = 0; i <= range; i++) {
            if (N % 2 == 0) {
                for (int j = 0; j < range; j++) {
                    rotateHelper(matrix, N, i, j);
                }
            } else {
                for (int j = 0; j <= range; j++) {
                    rotateHelper(matrix, N, i, j);
                }
            }
        }
    }

    public static void rotateHelper(int[][] matrix, int N, int r1, int c1) {
        int r2 = c1, c2 = N - r1;
        int r3 = N - r1, c3 = N - c1;
        int r4 = N - c1, c4 = r1;
        int tmp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r4][c4];
        matrix[r4][c4] = matrix[r3][c3];
        matrix[r3][c3] = matrix[r2][c2];
        matrix[r2][c2] = tmp;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int[] tmp : matrix) {
            System.out.println(Arrays.toString(tmp));
        }
    }

}
