package transform.easy;

public class Valid_Sudoku {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] rowHash = new int[9];
            int[] colHash = new int[9];
            int[] ceilHash = new int[9];
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 48) {
                    rowHash[board[i][j] - 49]++;
                }
                if (board[j][i] > 48) {
                    colHash[board[j][i] - 49]++;
                }
                if (board[((int) (i / 3)) * 3 + j / 3][(i % 3) * 3 + (j % 3)] > 48) {
                    ceilHash[board[((int) (i / 3)) * 3 + j / 3][(i % 3) * 3 + (j % 3)] - 49]++;
                }
            }
            for (int k = 0; k < 9; k++) {
                if (rowHash[k] > 1 || colHash[k] > 1 || ceilHash[k] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = { "....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......" };
        char[][] c = new char[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            c[i] = strings[i].toCharArray();
        }
        System.out.println(isValidSudoku(c));

        // int[][] te = new int[9][9];
        //
        // int count = 1;
        // for (int i = 0; i < 9; i++) {
        // for (int j = 0; j < 9; j++) {
        // te[i][j] = count++;
        // }
        // }
        //
        // for (int i = 0; i < 9; i++) {
        // for (int j = 0; j < 9; j++) {
        // System.out.print(te[((int) (i / 3)) * 3 + j / 3][(i % 3) * 3 + (j % 3)] + " ");
        // }
        // System.out.println();
        // }

    }
}
