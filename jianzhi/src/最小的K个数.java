package src;

import java.util.ArrayList;

public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = input.length - 1; i >= input.length - k && i > 0; i--) {
            sort(input, i);
            list.add(0);
            swap(input, i, 0);
        }
        return list;
    }

    public void sort(int[] input, int last) {
        for (int f = (last - 1) / 2; f >= 0; f--) {
            sortSub(input, last, f, 2 * f + 1);
        }
    }

    public void sortSub(int[] input, int last, int f, int c) {
        while (c <= last) {
            if (c < last && input[c] > input[c + 1]) {
                c++;
            }
            if (input[c] < input[f]) {
                swap(input, f, c);
                f = c;
                c = 2 * f + 1;
            } else break;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
