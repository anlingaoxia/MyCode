package src;

import java.util.ArrayList;

public class 和为S的连续正数序列 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        if (sum < 0) {
            return all;
        }
        findHelper(all, sum, 1);
        return all;
    }

    public void findHelper(ArrayList<ArrayList<Integer>> all, int sum, int start) {
        if (start > sum) {
            return;
        }
        findSubHelper(all, new ArrayList<Integer>(), sum, start);
        findHelper(all, sum, start + 1);
    }

    public void findSubHelper(ArrayList<ArrayList<Integer>> all, ArrayList<Integer> list, int remain, int start) {
        if (remain == 0 && list.size() > 1) {
            all.add(list);
            return;
        } else if (remain < 0) {
            return;
        }
        list.add(start);
        findSubHelper(all, list, remain - start, start + 1);
    }
}
