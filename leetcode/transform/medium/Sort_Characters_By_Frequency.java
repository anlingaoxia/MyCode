package transform.medium;

import java.util.Arrays;

public class Sort_Characters_By_Frequency {
    public static String frequencySort(String s) {
        int[][] sHash = new int[130][2];
        for (int i = 0; i < sHash.length; i++) {
            sHash[i][0] = i;
        }

        char[] chars = s.toCharArray();
        for (char c : chars) {
            sHash[c][1]++;
        }

        Arrays.sort(sHash, (int[] a1, int[] a2) -> {
            if (a1[1] < a2[1]) return 1;
            else if (a1[1] == a2[1]) return 0;
            return -1;
        });
        char[] chars2 = new char[chars.length];
        int count = 0;
        for(int i = 0; i < sHash.length; i++) {
            if(sHash[i][1] < 1) break;
            for(int j = 0; j < sHash[i][1]; j++) {
                chars2[count + j] = (char) sHash[i][0];
            }
            count += sHash[i][1];
        }
        return String.valueOf(chars2);
    }

    public static void main(String[] args) {
        char[] a ={'a','b','c'};
        System.out.println(frequencySort("tree"));
    }
}
