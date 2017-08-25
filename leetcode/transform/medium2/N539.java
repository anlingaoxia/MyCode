package transform.medium2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class N539 {
    public static int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() < 2) return 0;
        sort(timePoints);
        return getTheMin(timePoints);
    }

    public static void sort(List<String> timePoints) {
        Comparator<String> comparator = (String s1, String s2) -> {
            for (int i = 0; i < 5; i++) {
                if (i == 2) continue;
                if (s1.charAt(i) > s2.charAt(i)) return 1;
                else if (s1.charAt(i) < s2.charAt(i)) return -1;
                else continue;
            }
            return 0;
        };
        Collections.sort(timePoints, comparator);
    }

    public static int getTheMin(List<String> timePoints) {
        int min = 720;
        String last = null;
        String start = null;
        for (Iterator<String> iterator = timePoints.iterator(); iterator.hasNext();) {
            String tmp = iterator.next();
            if (last == null) {
                last = tmp;
                start = tmp;
                continue;
            }
            int compute = minus(last, tmp);
            if (compute < min) min = compute;
            last = tmp;
        }
        int compute = minus(start, last);
        if (compute < min) min = compute;
        return min;
    }

    public static int minus(String s1, String s2) {
        int site0 = s2.charAt(0) - s1.charAt(0);
        int site1 = s2.charAt(1) - s1.charAt(1);
        int site3 = s2.charAt(3) - s1.charAt(3);
        int site4 = s2.charAt(4) - s1.charAt(4);
        int hour = site1 + 10 * site0;
        int minute = site4 + 10 * site3;
        int all = minute + 60 * hour;
        return all > 720 ? 1440 - all : all;
    }

    public static void main(String[] args) {
        String s0 = "00:13";
        String s1 = "12:12";
        System.out.println(minus(s0, s1));
    }

}
