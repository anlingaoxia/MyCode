package transform.medium;

import java.util.Arrays;

public class Magical_String {
    public static int magicalString(int n) {
        if (n <= 0) return 0;
        if (n < 3) return 1;
        int[] x = new int[n];
        func(x);
        int count = 0;
        for (int i : x) {
            if (i == 1) count++;
        }
        return count;
    }

    public static int get(int x) {
        int[] array = new int[x + 1];
        array[0] = 1;
        array[1] = 2;
        array[2] = 2;
        int temp = 3;
        int start = 3;
        int end = 4;
        int result = 1;
        while (start < x) {
            System.out.println(start + "   " + end + "   " + temp);
            for (int i = start; i <= end; i++) {
                array[i] = array[start - 1] ^ 3;
                result += array[i] & 1;
            }
            start = end + 1;
            end = start + array[temp++] - 1;
            System.out.println(Arrays.toString(array));
        }
        if (array[array.length - 1] == 1) result--;
        return result;
    }

    public static void func(int[] x) {
        x[0] = 1;
        x[1] = 2;
        int count = 1;
        for (int i = 1;; i++) {
            if (x[i] == 1) {
                if (count < x.length) {
                    if (x[count - 1] == 1) x[count] = 2;
                    else x[count] = 1;
                } else break;
            } else {
                if (x[count - 1] == 1) {
                    if (count < x.length) {
                        x[count] = 2;
                    } else break;
                    if (count + 1 < x.length) {
                        x[count + 1] = 2;
                    } else break;
                } else {
                    if (count < x.length) {
                        x[count] = 1;
                    } else break;
                    if (count + 1 < x.length) {
                        x[count + 1] = 1;
                    } else break;
                }
            }
            count += x[i];
        }
    }

    public static void main(String[] args) {
        int temp = get(4);
        System.out.println("=====");
        System.out.println(temp);

    }
}
