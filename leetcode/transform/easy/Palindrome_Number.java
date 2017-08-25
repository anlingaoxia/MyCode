package transform.easy;

public class Palindrome_Number {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int count = 0;
        while (x / Math.pow(10, count) >= 1) {
            count++;
        }
        int first = 0;
        int last = 0;
        for (int i = 1, j = count; i < j; i++, j--) {
            int digitFirst = (int) Math.pow(10, j - 1);
            int digitLast = (int) Math.pow(10, i - 1);

            first += (x / digitFirst) % 10;
            last += (x / digitLast) % 10;
            
            if (last != first) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a = 2147483647;
        System.out.println(isPalindrome(1000021));
    }
}
