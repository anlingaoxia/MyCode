package transform.medium2;

import java.util.ArrayList;
import java.util.List;

public class N120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int start = triangle.get(0).get(0);
        int left = get(triangle, 1, 0, start);
        int right = get(triangle, 1, 1, start);
        return left < right ? left : right;

    }

    public static int get(List<List<Integer>> list, int depth, int index, int count) {
        if (depth == list.size()) return count;
        List<Integer> temp = list.get(depth);
        count += temp.get(index);
        int left = get(list, depth + 1, index, count);
        int right = get(list, depth + 1, index + 1, count);
        return left < right ? left : right;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        System.out.println(minimumTotal(list));
    }
}
