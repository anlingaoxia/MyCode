package transform.easy;

public class Power_of_Three {

    public static boolean isPowerOfThree(int n) {
        

        return false;
    }
    public static void main(String[] args) {
        for(int i = 1; i < 10; i++) {
            long n3 = (long) Math.pow(3, i);
            System.out.println(Long.toBinaryString(n3));
        }
    }
}
