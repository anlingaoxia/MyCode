package transform.easy;

public class Max_Consecutive_Ones {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int Max = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                count++;
            } else {
                count = 0;
            }
            if (count > Max) {
                Max = count;
            }
        }
        return Max;
    }
    
    public static void main(String[] args) {
        
    }
    
    

}
