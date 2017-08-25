package transform.medium;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Duplicates_in_an_Array {
    public static List<Integer> findDuplicates(int[] nums) {
        int[] nHash = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nHash[nums[i] -1]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < nHash.length; j++) {
            if(nHash[j] > 1) list.add(j + 1);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] input = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDuplicates(input));
        
        

    }
}
