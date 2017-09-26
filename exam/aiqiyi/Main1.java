package aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[3];
        for (int i = 0; i < 3; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int length = array[0] + array[1] + array[2];
        if (array[0] + array[1] <= array[2]) {
            length = (array[0] + array[1]) * 2 - 1;
        }
        System.out.println(length);
    }
}
