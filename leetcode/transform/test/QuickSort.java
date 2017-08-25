package transform.test;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int index = sortOnce(array, start, end, getKey(array, start, end));
        quickSort(array, start, index - 1);
        quickSort(array, index + 1, end);
    }

    public static int getKey(int[] array, int start, int end) {
        if (start == 0) return 0;
        return end;
    }

    public static int sortOnce(int[] array, int i, int j, int key) {
        while (i < j) {
            while (i < j && array[key] < array[j])
                j--;
            swap(array, key, j);
            key = j;
            while (i < j && array[i] <= array[key])
                i++;
            swap(array, key, i);
            key = i;
        }
        array[i] = array[key];
        return i;
    }

    public static void swap(int[] array, int key, int swap) {
        if (key == swap) return;
        int temp = array[key];
        array[key] = array[swap];
        array[swap] = temp;
    }

    static void quick_sort(int s[], int l, int r) {
        System.out.println();
        System.out.println();
        System.out.println("chushi:" + l + "   " + r);
        System.out.println("==" + Arrays.toString(s));
        if (l < r) {
            // Swap(s[l], s[(l + r) / 2]); //���м��������͵�һ�������� �μ�ע1
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // ���������ҵ�һ��С��x����
                    j--;
                System.out.println(s[i] + "   " + s[j]);
                if (i < j) s[i++] = s[j];
                System.out.println(Arrays.toString(s));
                while (i < j && s[i] < x) // ���������ҵ�һ�����ڵ���x����
                    i++;
                System.out.println(s[i] + "   " + s[j]);
                if (i < j) s[j--] = s[i];
                System.out.println(Arrays.toString(s));
            }
            s[i] = x;
            System.out.println("jieshu:" + Arrays.toString(s));
            quick_sort(s, l, i - 1); // �ݹ����
            quick_sort(s, i + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] input = { 3, 1, 2 };
        System.out.println(Arrays.toString(input));
        // QuickSort quickSort = new QuickSort();
        // quickSort.quickSort(input, 0, input.length - 1);
        // System.out.println(Arrays.toString(input));
        quickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));

    }

}
