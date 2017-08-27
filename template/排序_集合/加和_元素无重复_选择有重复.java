package 排序_集合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 加和_元素无重复_选择有重复 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> all = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return all;
        }
        combinationSumHelper(candidates, target, all, new LinkedList<>(), 0);
        return all;
    }

    public void combinationSumHelper(int[] candidates, int remains, List<List<Integer>> all, LinkedList<Integer> list, int p) {
        if (remains == 0) {
            all.add(new ArrayList<>(list));
        } else if (remains < 0) {
            return;
        }
        for (int i = p; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSumHelper(candidates, remains - candidates[i], all, list, i);
            list.removeLast();
        }
    }
}
