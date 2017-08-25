package transform.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection_of_Two_Arrays_II {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        out: for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            while (nums1[i] < nums2[j]) {
                if (++i == nums1.length) {
                    break out;
                }
            }

            while (nums1[i] > nums2[j]) {
                if (++j == nums2.length) {
                    break out;
                }
            }

            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 9, 5 };
        int[] nums2 = { 9, 4, 9, 8, 4 };

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

}
