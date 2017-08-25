package transform.easy;

public class Plus_One {
    public int[] plusOne(int[] digits) {
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + plus;
            digits[i] = temp % 10;
            if ((plus = temp / 10) == 0) {
                break;
            }
        }
        if (plus == 1) {
            int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
