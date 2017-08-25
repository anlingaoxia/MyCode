package transform.medium;

import java.util.Arrays;

public class Minimum_Moves_to_Equal_Array_Elements_II {
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int average =  nums[nums.length / 2];
        int steps = 0;
        for(int n : nums) {
            steps += Math.abs(n - average);
        }
        return steps;
    }
    
    
    public static void main(String[] args) {
        int[] input = {1,0,0,8,6};
        System.out.println(minMoves2(input));
    }
}
