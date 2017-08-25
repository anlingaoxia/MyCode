package transform.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Queue_Reconstruction_by_Height {
    public static int[][] reconstructQueue(int[][] people) {
        for (int i = 1; i < people.length; i++) {
            for (int j = 0; j < i; j++) {
                if (exchange(people[j], people[i])) {
                    insertBefore(people, j, i);
                    break;
                }
            }
        }

//        for (int i = 1; i < people.length; i++) {
//            int count = 0;
//            if (people[i][1] == 0 && people[i][0] <= people[0][0])  {
//                insertBefore(people, 0, i);
//                continue;
//            }
//            for (int j = 0; j < i; j++) {
//                if (people[j][0] >= people[i][0]) count++;
//                if (count == people[i][1]) {
//                    insertAfter(people, j, i);
//                    break;
//                }
//            }
//        }
        for (int[] temp : people) {
            System.out.print(Arrays.toString(temp));
        }
        System.out.println();
        System.out.println();
        
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);       
        }
        return res.toArray(new int[people.length][]);
    }

    public static void insertBefore(int[][] array, int i, int j) {
        int[] temp = array[j];
        for (int n = j; n > i; n--) {
            array[n] = array[n - 1];
        }
        array[i] = temp;
    }

    public static void insertAfter(int[][] array, int i, int j) {
        if (j == i + 1) return;
        insertBefore(array, i + 1, j);
    }

    public static boolean exchange(int[] compared, int[] comparer) {
        if (comparer[0] > compared[0]) return true;
        else if (comparer[0] == compared[0] && comparer[1] < compared[1]) return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] input = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        input = reconstructQueue(input);
        for (int[] temp : input) {
            System.out.print(Arrays.toString(temp));
        }

    }
}
