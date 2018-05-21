package array;

import java.util.ArrayList;
import java.util.List;

public class N054 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        int N = matrix.length * matrix[0].length;
        int rs = 0;
        int re = matrix.length - 1;
        int cs = 0;
        int ce = matrix[0].length - 1;
        while (rs <= re && cs <= ce) {
            System.out.println(rs + "  " + re + "  " + cs + "  " + ce);
            addHelper(matrix, list, rs, re, cs, ce);
            rs++;
            re--;
            cs++;
            ce--;
        }
        return list;
    }

    public static void addHelper(int[][] matrix, List<Integer> list, int rs, int re, int cs, int ce) {
        if (rs == re) {
            for (int j = cs; j <= ce; j++) list.add(matrix[rs][j]);
            System.out.println("===rs == re" + list);
            return;
        } else if (cs == ce) {
            for (int i = rs; i <= re; i++) list.add(matrix[i][cs]);
            System.out.println("===cs == ce" + list);
            return;
        }
        for (int j = cs; j < ce; j++) list.add(matrix[rs][j]);
        System.out.println("===" + list);
        for (int i = rs; i < re; i++) list.add(matrix[i][ce]);
        System.out.println("===" + list);
        for (int j = ce; j > cs; j--) list.add(matrix[re][j]);
        System.out.println("===" + list);
        for (int i = re; i > rs; i--) list.add(matrix[i][cs]);
        System.out.println("===" + list);
    }

    public static void main(String[] args) {
        int[][] matrix = {{3}, {2}};
        System.out.println(spiralOrder(matrix));
    }

}
