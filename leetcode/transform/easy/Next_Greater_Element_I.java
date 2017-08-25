package transform.easy;

import java.util.Arrays;

public class Next_Greater_Element_I {
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] out = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            out[i] = -1;
        }
        boolean find = false;
        outer: for (int i = 0; i < findNums.length; i++) {
            find = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == findNums[i]) {
                    find = true;
                    continue;
                }
                if (find == true && nums[j] > findNums[i]) {
                    out[i] = nums[j];
                    continue outer;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] findNums = { 4, 1, 2 };
        int[] nums = { 1, 3, 4, 2 };
        System.out.println(Arrays.toString(nextGreaterElement(findNums, nums)));
    }

}
