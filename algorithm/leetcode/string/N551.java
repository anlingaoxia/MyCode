package string;

public class N551 {
    public static boolean checkRecord(String s) {
        if (s == null || s.length() == 0) return false;
        int aN = 0;
        int lN = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                if (lN == 2) return false;
                lN++;
            } else {
                lN = 0;
                if (s.charAt(i) == 'A') aN++;
            }
        }
        return aN <= 1;
    }

    public static void main(String[] args) {
        String s = "AA";
    }


}
