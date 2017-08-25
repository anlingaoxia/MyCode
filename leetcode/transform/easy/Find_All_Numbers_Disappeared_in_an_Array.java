package transform.easy;

import java.util.*;

public class Find_All_Numbers_Disappeared_in_an_Array {
    // 77ms wrong
    public static List<Integer> findDisappearedNumbers4(int[] nums) {
        Set<Integer> iNums = new HashSet<>();
        List<Integer> iList = new ArrayList<>();
        for (int i : nums) {
            iNums.add(i);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (iNums.add(i)) {
                iList.add(i);
            }
        }
        return iList;
    }

    // 49ms wrong
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> iList = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int length = nums.length;

        if (length == 0) {
            return iList;
        }

        if (nums[0] != 1) {
            for (int i = 1; i < nums[0]; i++) {
                System.out.println("first add:" + i);
                iList.add(i);
            }
        }

        if (nums[length - 1] != length) {
            for (int i = length; i > nums[length - 1]; i--) {
                System.out.println("last add:" + i);
                iList.add(i);
            }
        }

        if (length > 2) {
            int last = nums[0];
            for (int i = 1; i < nums[length - 1]; i++) {
                System.out.println("theNum:" + nums[i]);
                System.out.println("last:" + last);
                if (nums[i] != last) {
                    for (int j = 1; j < nums[i] - last; j++) {
                        System.out.println("add:" + (last + j));
                        iList.add(last + j);
                    }
                    last = nums[i];
                }
            }
        }

        return iList;
    }

    // 21ms wrong
    public static List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> iList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                iList.add(i + 1);
            }
        }

        return iList;
    }
    
    
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            res[nums[i] - 1]++;

        for (int j = 1; j <= res.length; j++)
            if (res[j - 1] == 0) result.add(j);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 27, 40, 6, 21, 14, 36, 10, 19, 44, 10, 41, 26, 39, 20, 25, 19, 14, 7, 29, 27, 40, 38, 11, 44, 4, 6, 48, 39, 9, 13, 7, 45, 41, 23, 31, 8, 24, 1, 3, 5, 28, 11, 49, 29, 18, 4, 38,
                32, 24, 15 };
        System.out.println(findDisappearedNumbers(nums));

    }

}
