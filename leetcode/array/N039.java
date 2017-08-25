package array;

import java.util.ArrayList;
import java.util.List;

public class N039 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> template = new ArrayList<>();
        sumHelper(candidates, target, all, template, 0);
        return all;
    }

    public static void sumHelper(int[] cadidates, int remain, List<List<Integer>> all, List<Integer> template, int start) {
        if (remain < 0) return;
        else if (remain == 0) {
            all.add(template);
            return;
        }
        for (int i = start; i < cadidates.length; i++) {
            List<Integer> tmp = new ArrayList<>(template);
            tmp.add(cadidates[i]);
            sumHelper(cadidates, remain - cadidates[i], all, tmp, i );
        }
    }




    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        System.out.println(combinationSum(nums, 7));
    }

}
