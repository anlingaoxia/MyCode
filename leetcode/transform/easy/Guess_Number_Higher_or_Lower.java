package transform.easy;

public class Guess_Number_Higher_or_Lower {
    public static int guessNumber(int n) {
        return ErfenSearch(1, n);
    }

    public static int ErfenSearch(int low, int high) {
        int mid = (int) ((double) low / 2 + (double) high / 2);
        if (low < high) {
            if (guess(mid) == 1) {
                return ErfenSearch(low, mid - 1);
            } else if (guess(mid) == -1) {
                return ErfenSearch(mid + 1, high);
            }
        }
        return mid;
    }

    public static int guess(int num) {
        if (num > 6) {
            return 1;
        } else if (num < 6) {
            return -1;
        }
        return 0;
    }

    // 1702766719
    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

}
