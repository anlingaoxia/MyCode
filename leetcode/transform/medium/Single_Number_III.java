package transform.medium;

import java.util.Arrays;

public class Single_Number_III {

    public static int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        System.out.println(diff);
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = { 0, 0 }; // this array stores the two numbers we will return
        System.out.println(diff);
        for (int num : nums) {
            if ((num & diff) == 0) {
                System.out.println("one:" + num);
                System.out.println("one rets:" + rets[0]);
                rets[0] ^= num;
            } else {
                System.out.println("two:" + num);
                System.out.println("two rets:" + rets[1]);
                rets[1] ^= num;
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        int[] input = { 1, 2, 1, 2, 8, 4,6,6,7,7 };
        System.out.println(Arrays.toString(singleNumber(input)));
    }

}
