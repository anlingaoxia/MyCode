package transform.medium;

import java.util.Arrays;

public class Minesweeper {
    public static char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] > 48 && board[x][y] < 58 || board[x][y] == 'B') {
            return board;
        } else if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        boolean[][] find = new boolean[board.length][board[0].length];
        findNext(find, board, x, y);
        for(boolean[] temp : find) {
            System.out.println(Arrays.toString(temp));
        }
        return board;
    }

    public static void findNext(boolean[][] find, char[][] board, int x, int y) {
//        if (findMines(find, board, x, y)) return;
        if (x > 0 && !find[x - 1][y]) {
            findNext(find, board, x - 1, y);
        }
        if (y > 0 && !find[x][y - 1]) {
            findNext(find, board, x, y - 1);
        }
        if (x < board.length - 1 && !find[x + 1][y]) {
            findNext(find, board, x + 1, y);
        }
        if (y < board[0].length - 1 && !find[x][y + 1]) {
            findNext(find, board, x, y + 1);
        }
    }

    public static boolean findMines(boolean[][] find, char[][] board, int x, int y) {
        System.out.println(x + "    " +y);
        find[x][y] = true;
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i < 0 || x + i >= board.length || y + j < 0 || y + j >= board[0].length) continue;
                else if (board[x + i][y + j] == 'M') count++;
            }
        }
        if (count == 0) {
            board[x][y] = 'B';
            return false;
        }
        board[x][y] = (char) ('0' + count);
        return true;
    }

    public static char[][] trans(String[] strings) {
        char[][] chars = new char[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            chars[i] = strings[i].toCharArray();
        }
        return chars;
    }

    public static void main(String[] args) {
        String[] strings = { "EEEEE", "EEMEE", "EEEEE", "EEEEE" };

        char[][] board = trans(strings);

        for (char[] temp : board) {
            System.out.println(Arrays.toString(temp));
        }
        System.out.println();

        updateBoard(board, new int[] { 3, 0 });
        for (char[] temp : board) {
            System.out.println(Arrays.toString(temp));
        }

    }

}
