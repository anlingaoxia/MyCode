package 排序_集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 排序_元素有重复 {
    //排序
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return all;
        }
        Arrays.sort(nums);
        permuteUniqueHelper(nums, all, new LinkedList<>(), new boolean[nums.length]);
        return all;
    }

    public void permuteUniqueHelper(int[] nums, List<List<Integer>> all, LinkedList<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            all.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            permuteUniqueHelper(nums, all, list, used);
            list.removeLast();
            used[i] = false;
        }
    }

    //交换
    public List<List<Integer>> permuteUnique_ex(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return all;
        }
        permuteUnique_exHelper(nums, all, 0);
        return all;
    }

    public void permuteUnique_exHelper(int[] nums, List<List<Integer>> all, int p) {
        if (p == nums.length) {
            List<Integer> newList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                newList.add(nums[i]);
            }
            all.add(newList);
        }
        for (int i = p; i < nums.length; i++) {
            if (!isContainDuplicate(nums, i)) {
                swap(nums, i, p);
                permuteUnique_exHelper(nums, all, p + 1);
                swap(nums, i, p);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public boolean isContainDuplicate(int[] nums, int p) {
        for (int i = p + 1; i < nums.length; i++) {
            if (nums[i] == nums[p]) {
                return true;
            }
        }
        return false;
    }
}
