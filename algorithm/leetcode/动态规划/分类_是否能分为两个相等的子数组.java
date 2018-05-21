package 动态规划;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 */
public class 分类_是否能分为两个相等的子数组 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum & 1) > 0) {
            return false;
        }
        int part = sum / 2;





        return false;
    }

}
