package transform.easy;

public class Base_7 {
    public static String convertToBase7(int num) {
        int count = Math.abs(num);
        String out = "";
        while (count >= 7) {
            out = count % 7 + out;
            count /= 7;
        }
        out = count + out;

        return num < 0 ? "-" + out : out;
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
    }
}
