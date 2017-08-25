package transform.easy;

import java.util.Arrays;

public class Move_Zeroes {
    // 21ms
    public static void moveZeroes(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        boolean hasThree = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        one = j;
                        for (int k = j + 1; k < nums.length; k++) {
                            if (nums[k] != 0) {
                                two = k;
                                exchange3(nums, zero, one, two);
                                hasThree = true;
                                break;
                            }
                        }
                        if (!hasThree) {
                            exchange2(nums, zero, one);
                        }
                        hasThree = false;
                        break;
                    }
                }
            }
        }

    }

    public static void exchange2(int[] nums, int zero, int one) {
        nums[zero] = nums[one];
        nums[one] = 0;
    }

    public static void exchange3(int[] nums, int zero, int one, int two) {
        nums[zero] = nums[one];
        nums[one] = nums[two];
        nums[two] = 0;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
