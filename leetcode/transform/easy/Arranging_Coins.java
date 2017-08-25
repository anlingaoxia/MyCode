package transform.easy;

public class Arranging_Coins {
    public static int arrangeCoins(int n) {
        int count = 1;
        while (n - count >= 0) {
            n = n - count;
            count++;
        }
        return count - 1;

    }

    public static void main(String[] args) {
        // for (int i = 0; i < 100; i++) {
        // System.out.println(arrangeCoins(i));
        // }
        System.out.println(arrangeCoins(100));
    }

}
