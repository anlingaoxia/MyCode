package src;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class 把数组排成最小的数 {
    public static String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        final HashMap<Integer, char[]> map = new HashMap<>();
        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
            map.put(nums[i], nums[i].toString().toCharArray());
        }

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                char[] c1 = map.get(o1);
                char[] c2 = map.get(o2);
                char[] c12 = new char[c1.length + c2.length];
                char[] c21 = new char[c1.length + c2.length];
                System.arraycopy(c1, 0, c12, 0, c1.length);
                System.arraycopy(c2, 0, c12, c1.length, c2.length);
                System.arraycopy(c2, 0, c21, 0, c2.length);
                System.arraycopy(c1, 0, c21, c2.length, c1.length);
                for (int i = 0; i < c12.length; i++) {
                    if (c12[i] < c21[i]) {
                        return -1;
                    } else if (c12[i] > c21[i]) {
                        return 1;
                    }
                }
                return 0;
            }
        };
        Arrays.sort(nums, comparator);

        StringBuilder sb = new StringBuilder();
        for (Integer i : nums) {
            sb.append(i);
        }
        return sb.toString();
    }
}
