package 排序_集合;

import java.util.ArrayList;
import java.util.List;

public class 排序_元素无重复_交换元素 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return all;
        }
        permuteHelper(nums, all, 0);
        return all;
    }

    public void permuteHelper(int[] nums, List<List<Integer>> all, int p) {
        if (p == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            all.add(list);
        }

        for (int i = p; i < nums.length; i++) {
            swap(nums, i, p);
            permuteHelper(nums, all, p + 1);
            swap(nums, i, p);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
