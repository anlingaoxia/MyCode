package src;

public class 数组中重复的数字 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) {
            duplication[0] = -1;
            return false;
        }
        int[][] hash = new int[length][2];
        for (int i = 0; i < numbers.length; i++) {
            hash[numbers[i]][0]++;
            if (hash[numbers[i]][1] == 0) {
                hash[numbers[i]][1] = i + 1;
            }
        }
        duplication[0] = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (hash[i][0] > 1 && hash[i][1] < duplication[0]) {
                duplication[0] = i;
            }
        }
        if (duplication[0] == Integer.MAX_VALUE) {
            duplication[0] = -1;
            return false;
        }
        return true;
    }
}
