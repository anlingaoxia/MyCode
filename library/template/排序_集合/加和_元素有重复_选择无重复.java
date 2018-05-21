package 排序_集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 加和_元素有重复_选择无重复 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> all = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return all;
        }
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, all, new LinkedList<>(), 0);
        return all;
    }

    public void combinationSum2Helper(int[] candidates, int remains, List<List<Integer>> all, LinkedList<Integer> list, int p) {
        if (remains == 0) {
            all.add(new ArrayList<>(list));
        } else if (remains < 0) {
            return;
        }
        for (int i = p; i < candidates.length; i++) {
            if (i > p && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            combinationSum2Helper(candidates, remains - candidates[i], all, list, i + 1);
            list.removeLast();
        }
    }

}
