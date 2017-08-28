package src;

public class 数组中的逆序对 {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return recurse(array, 0, array.length - 1);
    }

    public int recurse(int[] array, int i, int j) {
        if (i == j) {
            return 0;
        }
        int mid = (i + j) / 2;
        int left = recurse(array, i, mid);
        int right = recurse(array, mid + 1, j);
        int count = merge(array, i, mid, j);
        return left + right + count;
    }

    public int merge(int[] array, int i, int mid, int j) {
        int[] tmp = new int[j - i + 1];
        int count = 0, p = 0, p1 = i, p2 = mid + 1, l = mid - i + 1;
        while (p1 <= mid || p2 <= j) {
            if (p1 > mid || p2 <= j && array[p1] > array[p2]) {
                tmp[p++] = array[p2++];
                count += l;
            } else {
                tmp[p++] = array[p1++];
                l--;
            }
        }
        System.arraycopy(tmp, 0, array, i, tmp.length);
        return count;
    }

}
