package transform.easy;

import java.util.HashSet;
import java.util.Set;

public class Single_Number {
    // XOR A ^ A = 0;
    public int singleNumber1(int[] nums) {
        Set<Integer> iSet = new HashSet<>();
        Set<Integer> sSet = new HashSet<>();

        for (int i : nums) {
            if (!iSet.add(i)) {
                sSet.add(i);
            }
        }

        for (int i : nums) {
            if (sSet.add(i)) {
                return i;
            }
        }

        return 0;
    }

    public static int singleNumber2(int nums[]) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
            System.out.println(result);
            System.out.println();
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {336,336,222,4,4,8,8,3,3};
        System.out.println(singleNumber2(nums));
        
        
    }
    
    

}
