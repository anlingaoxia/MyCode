package transform.easy;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Remove_Duplicates_from_Sorted_Array {

    // 25ms
    public static int removeDuplicates2(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            nums[i] = iterator.next();
        }
        return set.size();
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int temp1 = 0;
        int temp2 = 2;
        int compare = nums[1];
        if (nums[0] == nums[1]) {
            temp1 = 1;
        } else {
            temp1 = 2;
        }

        for (; temp2 < nums.length; temp2++) {
            if (nums[temp2] != compare) {
                nums[temp1++] = nums[temp2];
                compare = nums[temp2];
            }
        }
        return temp1;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3, 3 };
        System.out.println(removeDuplicates(nums));
    }

}
