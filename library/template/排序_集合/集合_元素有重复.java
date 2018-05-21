package 排序_集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 集合_元素有重复 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return all;
        }
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, all, new LinkedList<>(), 0);
        return all;
    }

    public void subsetsWithDupHelper(int[] nums, List<List<Integer>> all, LinkedList<Integer> list, int p) {
        all.add(new ArrayList<>(list));
        for (int i = p; i < nums.length; i++) {
            if (i > p && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsWithDupHelper(nums, all, list, i + 1);
            list.removeLast();
        }
    }

}
