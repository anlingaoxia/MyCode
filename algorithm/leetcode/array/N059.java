package array;

import java.util.Arrays;

public class N059 {
    public static int[][] generateMatrix(int n) {
        int[][] square = new int[n][n];
        int N = n * n;
        int r = 0;
        int c = 0;
        int mode = 0;
        for (int i = 1; i <= N; i++) {
            if (square[r][c] != 0) {
                r++;
                c++;
                mode = 0;
            }
            square[r][c] = i;
            if (r == c && r < n / 2) {
                c++;
                mode = 0;
            } else if (r == c && r >= n / 2) {
                c--;
                mode = 1;
            } else if (r + c + 1 == n && r < c) {
                r++;
                mode = 2;
            } else if (r + c + 1 == n && r > c) {
                r--;
                mode = 3;
            } else {
                if (mode == 0) c++;
                else if (mode == 1) c--;
                else if (mode == 2) r++;
                else if (mode == 3) r--;
            }
        }
        return square;
    }

    public static void main(String[] args) {
        int[][] square = generateMatrix(2);
        for (int[] t : square) {
            System.out.println(Arrays.toString(t));
        }
    }


}
