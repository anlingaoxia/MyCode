package string;

public class N043 {
    public String multiply(String num1, String num2) {
        int[] arr1 = getIntArray(num1.toCharArray());
        int[] arr2 = getIntArray(num2.toCharArray());
        int[] arr = new int[arr1.length + arr2.length + 1];
        int p = arr.length - 1;
        for (int i = arr1.length - 1; i >= 0; i--) {
            merge(arr, arr2, arr1[i], p--);
        }
        char[] ctr = getCharArray(arr);
        int offset = 0;
        for (char c : ctr) {
            if (c == '0') offset++;
            else break;
        }
        return offset == ctr.length ? "0" : new String(ctr, offset, ctr.length - offset);
    }

    public int[] getIntArray(char[] ctr) {
        int[] arr = new int[ctr.length];
        for (int i = 0; i < ctr.length; i++) {
            arr[i] = ctr[i] - 48;
        }
        return arr;
    }

    public static char[] getCharArray(int[] arr) {
        char[] ctr = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ctr[i] = (char) (arr[i] + 48);
        }
        return ctr;
    }

    public void merge(int[] arr, int[] arr2, int n, int p) {
        int ten = 0, one = 0;
        for (int i = arr2.length - 1; i >= 0; i--) {
            int product = arr2[i] * n + arr[p] + ten;
            ten = product / 10;
            one = product % 10;
            arr[p--] = one;
        }
        if (ten != 0) arr[p] = ten;
    }
}
