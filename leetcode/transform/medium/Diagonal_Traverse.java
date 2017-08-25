package transform.medium;

import java.util.Arrays;

public class Diagonal_Traverse {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[]{}; 
        boolean up = true;
        int height = matrix.length - 1;
        int width = matrix[0].length - 1;
        int[] res = new int[matrix[0].length * matrix.length];
        int count = 0;
        for (int i = 0, j = 0; i <= height && j <= width;) {
            res[count++] = matrix[i][j];
            if (up) {
                if (i != 0 && j != width) {
                    i--;
                    j++;
                } else if (j == width) {
                    i++;
                    up = false;
                } else {
                    j++;
                    up = false;
                }
            } else {
                if (i != height && j != 0) {
                    i++;
                    j--;
                } else if (i == height) {
                    j++;
                    up = true;
                } else {
                    i++;
                    up = true;
                }
            }
            System.out.println(i + "   " + j + "   " + up);
            System.out.println();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 3 }, { 2 } };
        System.out.println(Arrays.toString(findDiagonalOrder(matrix)));

    }
}
