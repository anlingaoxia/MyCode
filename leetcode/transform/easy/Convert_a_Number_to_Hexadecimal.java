package transform.easy;

public class Convert_a_Number_to_Hexadecimal {
    public static String toHex2(int num) {
        String binary = "";
        String result = "";
        if (num > 0) {
            binary = toBinaryC(num, true, 32);
        } else if (num < 0) {
            binary = toBinaryC(-num, false, 32);
        } else {
            return "0";
        }
        System.out.println(binary);
        for (int i = 0; i < 32; i += 4) {
            String temp = binaryToHex(binary.substring(i, i + 4));
            if (!temp.equals("0")) {
                result += temp;
            }
        }
        return result;
    }

    public static String toHex(int num) {
        String binary = Integer.toBinaryString(num);
        System.out.println(binary);
        String result = "";
        for (int i = binary.length(); i > 0; i -= 4) {
            String temp = "";
            if (i >= 4) {
                temp = binaryToHex(binary.substring(i - 4, i));
            } else {
                temp = binaryToHex(binary.substring(0, i));
            }
            result = temp + result;
        }
        return result;
    }

    public static String binaryToHex(String n) {
        int count = 0;
        for (int i = 0; i < 4 && i < n.length(); i++) {
            count += (int) ((n.charAt(n.length() - 1 - i) - 48) * Math.pow(2, i));
        }
        if (count > 9) {
            return String.valueOf((char) (count + 87));
        }
        return String.valueOf(count);
    }

    public static String toBinaryO(int n, boolean plus, int k) {
        int quotient = 0;
        int remainder = 0;
        String result = "";
        do {
            quotient = n / 2;
            remainder = n % 2;
            result = remainder + result;
        } while (quotient >= 1);
        result = quotient + result;
        for (int i = result.length(); i < k - 1; i++) {
            result = "0" + result;
        }
        return plus ? "0" + result : "1" + result;
    }

    public static String toBinaryC(int n, boolean plus, int k) {
        int quotient = 0;
        int remainder = 0;
        String result = "";
        do {
            quotient = n / 2;
            remainder = n % 2;
            result = remainder + result;
        } while (quotient >= 1);
        result = quotient + result;
        for (int i = result.length(); i < k - 1; i++) {
            result = "0" + result;
        }
        if (!plus) {
            result = result.replaceAll("0", "T").replaceAll("1", "0").replaceAll("T", "1");
        }
        return plus ? "0" + result : "1" + result;
    }

    public static void main(String[] args) {
        int num = 26;
        System.out.println(toHex(num));

    }
}
