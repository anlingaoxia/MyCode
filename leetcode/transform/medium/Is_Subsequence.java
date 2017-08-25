package transform.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class Is_Subsequence {
    // bad
    public static boolean isSubsequence(String s, String t) {
        LinkedList<Integer>[] lists = new LinkedList[26];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }
        char[] tc = t.toCharArray();
        for (int i = 0; i < tc.length; i++) {
            lists[tc[i] - 97].add(i);
        }

        char[] sc = s.toCharArray();
        LinkedList<Integer> temp = null;
        int compare = -1;
        for (int i = 0; i < sc.length; i++) {
            temp = lists[sc[i] - 97];
            if (!temp.isEmpty()) {
                int m = temp.removeFirst();
                while (m < compare && !temp.isEmpty()) {
                    m = temp.removeFirst();
                }
                if (m > compare) compare = m;
                else return false;
            } else return false;
        }
        return true;
    }

    public static boolean isSubsequence2(String s, String t) {
        if(s.length() == 0) return true;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        int temp = 0;
        for (int i = 0; i < tc.length && temp < sc.length; i++) {
            if (sc[temp] != tc[i]) continue;
            temp++;
        }

        if (temp == sc.length) return true;
        return false;
    }

    public static void main(String[] args) {
        try {
            File file = new File("D://data.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s = "leeeeetcode";
            String t = br.readLine();
            System.out.println(isSubsequence2(s, t));
        } catch (Exception e) {

        }
    }

}
