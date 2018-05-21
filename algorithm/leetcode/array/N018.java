package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> all = new ArrayList<>();
        if (nums == null || nums.length == 0) return all;
        Arrays.sort(nums);
        sumHelper(nums, all, new ArrayList<>(), target, 1, 0);
        return all;
    }

    public void sumHelper(int[] nums,List<List<Integer>> all, List<Integer> template, int remain, int n, int start) {
        if (n == 5 && remain == 0) {
            all.add(template);
            return;
        } else if (n == 5 && remain != 0) return;
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i -1]) {
                List<Integer> tmp = new ArrayList<>(template);
                tmp.add(nums[i]);
                sumHelper(nums, all, tmp, remain - nums[i], n + 1, i + 1);
            }
        }
    }
}
