package transform.medium;

import java.util.ArrayList;

public class Arithmetic_Slices {
    public static int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int start = 0;
        int minus = A[0] - A[1];
        boolean has = false;
        ArrayList<Integer> record = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            int tempMinus = A[i] - A[i + 1];
            if (tempMinus != minus && !has) {
                has = false;
                minus = tempMinus;
            } else if (tempMinus != minus && has) {
                has = false;
                minus = tempMinus;
                record.add(start);
                record.add(i);
            } else if (!has) {
                has = true;
                start = i - 1;
            }
        }
        if (has) {
            record.add(start);
            record.add(A.length - 1);
        }
        int count = 0;
        for (int i = 0; i < record.size(); i += 2) {
            int s = record.get(i);
            int e = record.get(i + 1);
            count += (e - s - 1) * (e - s) / 2;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4 };
        System.out.println(numberOfArithmeticSlices(A));
    }
}
