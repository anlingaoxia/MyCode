package transform.easy2;

public class Range_Sum_Query {

}

class NumArray {
    int[] nums;
    int all;

    public NumArray(int[] nums) {
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            all += nums[i];
        }
    }

    public int sumRange(int i, int j) {
        int res = 0;
        if ((j - i) < nums.length / 2) {
            for (int n = i; n <= j; n++)
                res += nums[n];
        } else {
            res = all;
            for(int m = 0; m < i; m++) {
                res -= nums[m];
            }
            for(int n = j + 1; n < nums.length; n++) {
                res -= nums[n];
            }
        }
        return res;
    }
}