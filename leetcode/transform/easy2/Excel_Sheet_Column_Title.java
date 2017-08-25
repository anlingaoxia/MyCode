package transform.easy2;

public class Excel_Sheet_Column_Title {
    public static String convertToTitle(int n) {
        int length = 1;
        for (int i = 1; i < 9; i++) {
            int width = (int) Math.pow(26, i);
            if (n - width > 0) {
                n -= width;
                length++;
            } else break;
        }
        String out = "";
        int up = 0;
        for (int i = 0; i < length; i++) {
            if (n > 0) {
                int remainder = n % 26;
                char c = (char) ((remainder == 0 ? 90 : remainder + 64) + up);
                if (remainder == 0) up = 0;
                else up = 1;
                out = c + out;
                n /= 26;
            } else {
                out = 'A' + out;
            }
        }
        return out;
    }

    public static String correct(int n) {
        String out = "";
        while (n > 0) {
            int quotient = n / 26;
            int remainder = n % 26;
            if (remainder == 0) {
                remainder = 26;
                quotient--;
            }
            out = (char) (remainder + 64) + out;
            n = quotient;
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(27));
        System.out.println(correct(27));
    }

}
