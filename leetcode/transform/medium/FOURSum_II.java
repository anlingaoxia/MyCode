package transform.medium;

import java.util.Arrays;

public class FOURSum_II {
    // time limit exceed
    public static int fourSumCountX(int[] A, int[] B, int[] C, int[] D) {
        int[] AB = new int[A.length * B.length];
        int[] CD = new int[C.length * D.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                AB[i * B.length + j] = A[i] + B[j];
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                CD[i * D.length + j] = C[i] + D[j];
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);
        System.out.println(Arrays.toString(AB));
        System.out.println(Arrays.toString(CD));

        int count = 0;
        int couples = 0;
        for (int i = 0, j = CD.length - 1; i < AB.length;) {
            if (i != 0 && AB[i] == AB[i - 1]) {
                count += couples;
                i++;
                continue;
            } else if (i != 0 && AB[i] != AB[i - 1]) {
                couples = 0;
            }
            while (j >= 0) {
                if (AB[i] + CD[j] == 0) {
                    couples++;
                    count++;
                    j--;
                } else if (AB[i] + CD[j] > 0) {
                    j--;
                } else break;
            }
            i++;
        }
        System.out.println("count:" + count);
        return count;
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        return 0;
    }

    public static void main(String[] args) {
        int[] A = { 0, 1, -1 };
        int[] B = { -1, 1, 0 };
        int[] C = { 0, 0, 1 };
        int[] D = { -1, 1, 1 };
        fourSumCountX(A, B, C, D);
    }
}
