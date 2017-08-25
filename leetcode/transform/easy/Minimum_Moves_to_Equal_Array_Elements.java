package transform.easy;

public class Minimum_Moves_to_Equal_Array_Elements {

    // 11ms O(n)
    public static int minMoves(int[] nums) {
        int min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
            }
        }
        
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            count += (nums[i] - min);
        }
        return count;
    }

    // ��������
    public static int moveOnce(int[] nums) {
        boolean equal = true;
        int theMax = 0;
        int max = nums[theMax];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != max) {
                equal = false;
            }
            if (nums[i] > max) {
                theMax = i;
                max = nums[i];
            }
        }
        if (equal) {
            return 0;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i != theMax) {
                    nums[i]++;
                }
            }
            return moveOnce(nums) + 1;
        }
    }
    
    

    public static void main(String[] args) {
        int[] nums = { 1, 2147483647 };
        System.out.println(minMoves(nums));

    }
}
