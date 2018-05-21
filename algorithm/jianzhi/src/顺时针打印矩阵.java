package src;

import java.util.ArrayList;

public class 顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int sX = 0, sY = 0, eX = matrix[0].length - 1, eY = matrix.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (sX <= eX && sY <= eY) {
            printHelper(matrix, list, sX++, sY++, eX--, eY--);
        }
        return list;
    }

    public void printHelper(int[][] matrix, ArrayList<Integer> list, int sX, int sY, int eX, int eY) {
        if (sX == eX) {
            for (int i = sY; i <= eY; i++) list.add(matrix[i][sX]);
        } else if (sY == eY) {
            for (int i = sX; i <= eX; i++) list.add(matrix[sY][i]);

        } else {
            for (int i = sX; i < eX; i++) list.add(matrix[sY][i]);
            for (int i = sY; i < eY; i++) list.add(matrix[i][eX]);
            for (int i = eX; i > sX; i--) list.add(matrix[eY][i]);
            for (int i = eY; i > sY; i--) list.add(matrix[i][sX]);
        }
    }

}
