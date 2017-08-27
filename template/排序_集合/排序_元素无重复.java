package 排序_集合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 排序_元素无重复 {
    //排序
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return all;
        }
        permuteHelper(nums, all, new LinkedList<>());
        return all;
    }

    public void permuteHelper(int[] nums, List<List<Integer>> all, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            all.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            permuteHelper(nums, all, list);
            list.removeLast();
        }
    }

    //交换
    public List<List<Integer>> permute_ex(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return all;
        }
        permute_exHelper(nums, 0, all);
        return all;
    }

    public void permute_exHelper(int[] nums, int p, List<List<Integer>> all) {
        if (p == nums.length) {
            all.add(newList(nums));
        }
        for (int i = p; i < nums.length; i++) {
            swap(nums, p, i);
            permute_exHelper(nums, p + 1, all);
            swap(nums, p, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public List<Integer> newList(int[] nums) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            newList.add(nums[i]);
        }
        return newList;
    }

}
