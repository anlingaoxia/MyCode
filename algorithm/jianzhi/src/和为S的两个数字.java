package src;

import java.util.ArrayList;

public class 和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int i = 0, j = array.length - 1, product = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        while (i < j) {
            int t = array[i] + array[j];
            if (t > sum) {
                j--;
            } else if (t < sum) {
                i++;
            } else {
                if (array[i] * array[j] < product) {
                    product = array[i] * array[j];
                    index1 = i;
                    index2 = j;
                }
                i++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (index1 >= 0) {
            list.add(array[index1]);
            list.add(array[index2]);
        }
        return list;
    }
}
