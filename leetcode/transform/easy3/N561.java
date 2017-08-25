package transform.easy3;

import java.util.Arrays;

public class N561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            count += nums[i++];
        }
        return count;
    }

}
