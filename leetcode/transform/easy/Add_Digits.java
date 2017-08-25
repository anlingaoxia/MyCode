package transform.easy;

public class Add_Digits {
    // 2ms
    public static int addDigits(int num) {
        int two1 = num / 10;
        int two0 = num % 10;

        if (two1 == 0) return two0;

        return addDigits(two1 + two0);
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

}
