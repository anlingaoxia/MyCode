package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N090 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length < 1) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            int size = list.size();
            for (int n = 0; n < size; n++) {
                List<Integer> last = list.get(n);
                for (int i = 1; i <= val; i++) {
                    List<Integer> tmp = new ArrayList<>(last);
                    for (int j = 0; j < i; j++) {
                        tmp.add(key);
                    }
                    list.add(tmp);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2,};
        System.out.println(subsetsWithDup(nums));

    }


}