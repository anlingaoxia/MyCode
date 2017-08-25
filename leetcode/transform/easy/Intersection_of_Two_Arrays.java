package transform.easy;

import java.util.*;

public class Intersection_of_Two_Arrays {
    // 7ms wrong
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> list3 = new ArrayList<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        for (Integer i : set1) {
            if (!set2.add(i)) {
                list3.add(i);
            }
        }
        int[] array3 = new int[list3.size()];
        for (int i = 0; i < list3.size(); i++) {
            array3[i] = list3.get(i);
        }
        return array3;
    }

    public static void main(String[] args) {
        int[] nums1 = { };
        int[] nums2 = { 2, 2 };
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

    }

}
