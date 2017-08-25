package transform.medium;

public class Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int products = 1;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeroCount++;
            else products *= nums[i];
        }

        int[] output = new int[nums.length];

        if (zeroCount > 1) return output;

        if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) output[i] = products;
                else output[i] = 0;
            }
            return output;
        }
        for (int i = 0; i < nums.length; i++) {
            output[i] = products / nums[i];
        }
        return output;
    }
}
