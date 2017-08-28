package src;

public class 数字在排序数组中出现的次数 {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0 || k < array[0] || k > array[array.length - 1]) {
            return 0;
        }
        int index = binarySearch(array, k);
        if (index == -1) {
            return 0;
        }
        int left = findLeftFirst(array, k, index);
        int right = findRightLast(array, k, index);
        return right - left + 1;
    }

    public int binarySearch(int[] array, int k) {
        int i = 0, j = array.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (array[mid] == k) {
                return mid;
            } else if (array[mid] > k) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    public int findLeftFirst(int[] array, int k, int index) {
        int i = 0, j = index - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (array[mid] == k) {
                if (mid == 0) {
                    return 0;
                } else if (array[mid - 1] != k) {
                    return mid;
                } else {
                    j = mid - 1;
                }
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public int findRightLast(int[] array, int k, int index) {
        int i = index + 1, j = array.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (array[mid] == k) {
                if (mid == array.length - 1) {
                    return array.length - 1;
                } else if (array[mid + 1] != k) {
                    return mid;
                } else {
                    i = mid + 1;
                }
            } else {
                j = mid - 1;
            }
        }
        return j;
    }
}
