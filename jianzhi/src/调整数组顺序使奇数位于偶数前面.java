package src;

import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    public static void reOrderArray(int[] array) {
        boolean notComplete = true;
        while (notComplete) {
            notComplete = false;
            for (int i = 0; i < array.length - 1; i++) {
                if ((array[i] & 1) == 0 && (array[i + 1] & 1) == 1) {
                    swap(array, i, i + 1);
                    notComplete = true;
                }
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 1, 3, 5, 7};
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}
