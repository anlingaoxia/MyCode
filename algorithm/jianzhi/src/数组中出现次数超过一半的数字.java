package src;

public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = findMax(array);
        return check(array, max) ? max : 0;
    }

    public int findMax(int[] array) {
        int max = 0, count = 0;
        for (int i : array) {
            if (count == 0) {
                max = i;
                count = 1;
                continue;
            }
            count += i == max ? 1 : -1;
        }
        return max;
    }

    public boolean check(int[] array, int max) {
        int count = 0;
        for (int i : array) {
            if (i == max) count++;
        }
        return count > array.length / 2;
    }
}
