package src;

public class 旋转数组的最小数字 {
    public int minNumberInRotateArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] > array[end]) {
                start = mid + 1;
            } else if (array[mid] < array[end]) {
                end = mid;
            } else {
                end--;
            }
        }
        return array[start];
    }
}
