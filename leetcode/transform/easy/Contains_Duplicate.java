package transform.easy;

import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate {
    public static boolean containsDuplicate(int[] nums) {
       
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
