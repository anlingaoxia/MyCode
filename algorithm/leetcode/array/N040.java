package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N040 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> all = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return all;
        Arrays.sort(candidates);
        sum2Helper(candidates, target, all, new ArrayList<>(), 0);
        return all;
    }


    public static void sum2Helper(int[] candidates, int remain, List<List<Integer>> all, List<Integer> template, int start) {
        if (remain < 0) return;
        else if (remain == 0) {
            all.add(template);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i == start || candidates[i] != candidates[i - 1]) {
                List<Integer> tmp = new ArrayList<>(template);
                tmp.add(candidates[i]);
                sum2Helper(candidates, remain - candidates[i], all, tmp, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(nums, 8));
    }

}
