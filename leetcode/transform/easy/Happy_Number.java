package transform.easy;

import java.util.HashSet;
import java.util.Set;

public class Happy_Number {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return loop(n, set);
    }

    public static boolean loop(int n, Set<Integer> set) {
        String nString = String.valueOf(n);
        int k = nString.length();
        if (n == Math.pow(10, k - 1)) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < k; i++) {
            int temp = nString.charAt(i) - 48;
            count += temp * temp;
        }
        if (!set.add(count)) {
            return false;
        }
        return loop(count, set);
    }

    public static void main(String[] args) {
    }

}
