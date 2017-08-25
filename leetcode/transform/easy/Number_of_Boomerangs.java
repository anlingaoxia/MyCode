package transform.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number_of_Boomerangs {
    // 336ms
    public static int numberOfBoomerangs(int[][] points) {
        int all = 0;
        for (int i = 0; i < points.length; i++) {
            int[] toBeCompared = points[i];
            Map<Integer, List<Integer>> info = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int d = countDistance2(toBeCompared, points[j]);
                    List<Integer> temp = info.getOrDefault(d, new ArrayList<>());
                    temp.add(j);
                    info.put(d, temp);
                }
            }
            for (List<Integer> k : info.values()) {
                int n = k.size();
                int count = n * (n - 1);
                all += count;
            }
        }
        return all;
    }

    public static int countDistance2(int[] arr1, int[] arr2) {
        return (int) (Math.pow(arr1[0] - arr2[0], 2) + Math.pow(arr1[1] - arr2[1], 2));
    }

    public static void main(String[] args) {
        int[][] points = { { 0, 0 }, { 1, 0 }, { 2, 0 } };
        System.out.println(numberOfBoomerangs(points));
    }

}
