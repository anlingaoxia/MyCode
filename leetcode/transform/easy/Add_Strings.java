package transform.easy;

public class Add_Strings {
    public static String addStrings(String num1, String num2) {
        int up = 0;
        String out = "";
        for (int i = 0; i < num1.length() || i < num2.length(); i++) {
            int n1i = 0;
            int n2i = 0;
            if (i < num1.length()) {
                n1i = num1.charAt(num1.length() - 1 - i) - 48;
            }
            if (i < num2.length()) {
                n2i = num2.charAt(num2.length() - 1 - i) - 48;
            }
            int ten = (n1i + n2i + up) / 10;
            int one = (n1i + n2i + up) % 10;
            up = ten;
            out = one + out;
        }
        return up == 0 ? out : up + out;
    }

    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "9";
        System.out.println(addStrings(num1, num2));
    }
}
