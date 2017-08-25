package transform.medium;

import java.util.*;

public class Top_K_Frequent_Elements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        ArrayList<Integer> temp;
        for (Map.Entry<Integer, Integer> entry : set) {
            temp = new ArrayList<>();
            temp.add(entry.getValue());
            temp.add(entry.getKey());
            lists.add(temp);
        }

        Collections.sort(lists, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0) < o2.get(0)) return 1;
                else if (o1.get(0) == o2.get(0)) return 0;
                return -1;
            }
        });
        temp = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            temp.add(lists.get(i).get(1));
        }
        return temp;
    }

    //����һ��sort ֱ��������ɢ�б�
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2 };
        System.out.println(topKFrequent(nums, 2));
    }
}
