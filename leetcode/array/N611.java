package array;

import java.util.Arrays;
import java.util.HashMap;

public class N611 {
    public static int triangleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Integer[] keys = new Integer[map.size()];
        map.keySet().toArray(keys);
        Arrays.sort(keys);
        System.out.println(map);
        int count = 0;
        for (int i = 0; i < keys.length; i++) {
            for (int j = i + 1; j < keys.length; j++) {
                for (int k = j + 1; k < keys.length; k++) {
                    if (checkHelper(keys[i], keys[j], keys[k])) {
                        count += map.get(keys[i]) * map.get(keys[j]) * map.get(keys[k]);
                        System.out.println(i + "  " + j + "  " + k);
                        System.out.println("count: " + count);
                    } else break;
                }
            }
        }
        System.out.println("first: " + count);

        for (int i = 0; i < keys.length; i++) {
            int n = map.get(keys[i]);
            if (n > 1) {
                int pairs = n * (n - 1) / 2;
                for (int j = 0; j < keys.length; j++) {
                    if (i != j && checkHelper(keys[i], keys[i], keys[j])) count += pairs * map.get(keys[j]);
                }
            }
            if (n > 2) {
                int triples = n * (n - 1) * (n - 2) / 6;
                if (keys[i] > 0) count += triples;
            }
            System.out.println("second: " + count);
        }
        return count;
    }

    public static boolean checkHelper(int a, int b, int c) {
        return a + b > c && b + c > a && a + c > b && a > 0;
    }


    public static int solve(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int sideLocate = nums.length - 1; sideLocate >= 2; sideLocate--) {
            int side1 = 0, side2 = sideLocate - 1;
            while (side1 < side2) {
                if (nums[side1] + nums[side2] > nums[sideLocate]) {
                    count += side2 - side1;
                    side2--;
                } else {
                    side1++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        System.out.println(solve(nums));
    }

}
