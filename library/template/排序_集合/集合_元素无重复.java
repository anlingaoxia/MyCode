package 排序_集合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 集合_元素无重复 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return all;
        }
        subsetsHelper(nums, all, new LinkedList<>(), 0);
        return all;
    }

    public void subsetsHelper(int[] nums, List<List<Integer>> all, LinkedList<Integer> list, int p) {
        all.add(new ArrayList<>(list));
        for (int i = p; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper(nums, all, list, i + 1);
            list.removeLast();
        }
    }
}
