package array;

import java.util.ArrayList;
import java.util.List;

public class N078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return list;
        for (int n : nums) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List<Integer> tmp = new ArrayList<>(list.get(i));
                tmp.add(n);
                list.add(tmp);
            }
        }
        return list;
    }
}
