package transform.easy;

public class Excel_Sheet_Column_Number {
    public static int titleToNumber(String s) {
        int res = 0;
        for (int i = s.length() - 1, count = 0; i >= 0; i--, count++) {
            int iMult = s.charAt(i) - 64;
            res += iMult * Math.pow(26, count);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AAA"));
    }

}
