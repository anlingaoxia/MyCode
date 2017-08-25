package transform.easy;

import java.util.Arrays;

public class Relative_Ranks {
    public static String[] findRelativeRanks(int[] nums) {
        int[] out = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            out[i] = nums.length;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    out[j]--;
                } else {
                    out[i]--;
                }
            }
        }
        Integer[] index = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));

        String[] res = new String[nums.length];
        for (int i = 0; i < res.length; i++) {
            if (out[i] == 1) {
                res[i] = "Gold Medal";
            } else if (out[i] == 2) {
                res[i] = "Silver Medal";
            } else if (out[i] == 3) {
                res[i] = "Bronze Medal";
            } else {
                res[i] = String.valueOf(out[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = { 20, 100, 10, 98, 56, 72 };
        System.out.println(Arrays.toString(findRelativeRanks(test)));
    }
}
