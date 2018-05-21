package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N079 {
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
            return false;
        boolean[][] record = new boolean[board.length][board[0].length];
        List<int[]> list = getStart(board, word.charAt(0));
        for (int[] tmp : list) {
            System.out.println(Arrays.toString(tmp));
        }
        for (int[] start : list) {
            if (findHelper(board, word, record, start[0], start[1], 0)) return true;
            System.out.println("=====");
        }
        return false;
    }

    public static boolean findHelper(char[][] board, String word, boolean[][] record, int r, int c, int n) {
        if (n == word.length()) return true;
        else if (r < 0 || r == board.length || c < 0 || c == board[0].length || record[r][c]) return false;

        if (word.charAt(n) != board[r][c])  return false;
        record[r][c] = true;
        boolean top = findHelper(board, word, record, r - 1, c, n + 1);
        boolean bottom = findHelper(board, word, record, r + 1, c, n + 1);
        boolean left = findHelper(board, word, record, r, c - 1, n + 1);
        boolean right = findHelper(board, word, record, r, c + 1, n + 1);
        boolean check = top || bottom || left || right;
        if (check) return true;
        record[r][c] = false;
        return false;
    }


    public static List<int[]> getStart(char[][] board, char start) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == start) list.add(new int[]{i, j});
            }
        }
        return list;
    }


}
