package array;

public class N080 {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        boolean canDuplicate = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && canDuplicate) {
                nums[index++] = nums[i];
                canDuplicate = false;
            } else if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
                canDuplicate = true;
            }
        }
        return index;
    }
}
