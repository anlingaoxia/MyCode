package transform.easy;

public class Find_the_Difference {
    public static char findTheDifference(String s, String t) {
        int[] sSet = new int[123];
        int[] tSet = new int[123];

        for (int i = 0; i < s.length(); i++) {
            sSet[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            tSet[t.charAt(i)]++;
        }
        for (int i = 0; i < 123; i++) {
            if (sSet[i] != tSet[i]) {
                return (char) i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));
    }
}
