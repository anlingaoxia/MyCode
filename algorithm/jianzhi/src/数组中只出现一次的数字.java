package src;

import java.util.ArrayList;

public class 数组中只出现一次的数字 {
    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int xor = array[0];
        for (int i = 1; i < array.length; i++) {
            xor ^= array[i];
        }
        int site = 1;
        while ((xor & 1) == 0) {
            xor = xor >> 1;
            site = site << 1;
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i : array) {
            if ((i & site) == 0) {
                list1.add(i);
            } else {
                list2.add(i);
            }
        }
        for (Integer i : list1) {
            num1[0] ^= i;
        }
        for (Integer i : list2) {
            num2[0] ^= i;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3, 3, 4, 5};
        int[] num1 = {0};
        int[] num2 = {0};
        FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

}
