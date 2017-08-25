package transform.medium2;

import java.util.HashSet;
import java.util.Set;

public class N421 {
    public int findMaximumXOR(int[] nums) {

        return 0;
    }

    public static int add(int a, int b) {
        while (b != 0) {
            int tempA = a ^ b;
            int tempB = (a & b) << 1;
            System.out.println(Integer.toBinaryString(tempA) + "   " + Integer.toBinaryString(tempB));
            a = tempA;
            b = tempB;
        }
        return a;
    }

    public static int findMaximumXOR2(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
//                System.out.println(num & mask);
                set.add(num & mask);
            }
            System.out.println("=====");
            int tmp = max | (1 << i);
            System.out.println(tmp);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = { 3, 10, 5, 25, 2, 8 };
        System.out.println(findMaximumXOR2(input));
    }

}
