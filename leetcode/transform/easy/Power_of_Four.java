package transform.easy;

public class Power_of_Four {
    public static boolean isPowerOfFour(int num) {
        if(num < 1) {
            return false;
        }
        int count = 0;
        while (num % 2 == 0) {
            num = num / 2;
            count++;
        }
        if(num == 1 && count % 2 == 0) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(2));
    }
}
