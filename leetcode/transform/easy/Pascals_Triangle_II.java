package transform.easy;

import java.util.Arrays;
import java.util.List;

public class Pascals_Triangle_II {
    public static List<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];
        row[0] = 1;
        if (rowIndex > 0) {
            row[1] = 1;
            for (int i = 2; i <= rowIndex; i++) {
                row[i] = 1;
                for (int j = i - 1; j > 0; j--) {
                    row[j] = row[j] + row[j - 1];
                }
            }
        }

        return Arrays.asList(row);
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
