package 排序_集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 排序_元素无重复_排序添加 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return all;
        }
        Arrays.sort(nums);
        permuteHelper(nums, all, new LinkedList<>(), new boolean[nums.length]);
        return all;
    }

    public void permuteHelper(int[] nums, List<List<Integer>> all, LinkedList<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            all.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            permuteHelper(nums, all, list, used);
            list.removeLast();
            used[i] = false;
        }
    }
}
