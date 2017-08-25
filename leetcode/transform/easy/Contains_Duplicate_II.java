package transform.easy;

import java.util.HashMap;
import java.util.Map;

public class Contains_Duplicate_II {
    // �Ƿ�������Ԫ����ͬ������Ԫ�ص�λ�� <k ������array�л�Ҫ������Ԫ�أ�
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        int[] nHash = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums.length && nums[i] >= 0) {
                if (nHash[nums[i]] > 0 && Math.abs(i + 1 - nHash[nums[i]]) <= k) return true;
                nHash[nums[i]] = i + 1;
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer temp;
        for (int i = 0; i < nums.length; i++) {
            if ((temp = map.get(nums[i])) != null && (i + 1 - temp) <= k) {
                return true;
            }
            map.put(nums[i], i + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        System.out.println(containsNearbyDuplicate(nums, 0));

    }

}
