package transform.easy;

import java.util.ArrayList;
import java.util.List;

public class Reverse_Vowels_of_a_String {
    public static String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 'a' || cs[i] == 'e' || cs[i] == 'i' || cs[i] == 'o' || cs[i] == 'u' || cs[i] == 'A' || cs[i] == 'E' || cs[i] == 'I' || cs[i] == 'O' || cs[i] == 'U') {
                list.add(i);
            }
        }

        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            char temp = cs[list.get(i)];
            cs[list.get(i)] = cs[list.get(j)];
            cs[list.get(j)] = temp;
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));

    }
}
