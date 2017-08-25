package transform.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Target_Sum {
    public int findTargetSumWays(int[] nums, int S) {
        int count = 0;
        for (int i : nums)
            count += i;
        count += S;
        if (count % 2 != 0) return 0;
        count = count / 2 - S;
        
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        
        int temp = 0;
        int[] res = new int[nums.length];
        for(int i = 0; nums[i] < count; i++) {
            list.add(temp);
            temp += nums[i];
            list.add(temp);
        }
        
        
        
        
        

        return 0;
    }
}
