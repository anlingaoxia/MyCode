package transform.easy;

public class Nth_Digit {
    public static int findNthDigit(int n) {
        int start = 0;
        int end = 0;
        int Num = 0;
        for (int i = 0;; i++) {
            start = end;
            end += (i + 1) * 9 * Math.pow(10, i);
            System.out.println("start:" + start);
            System.out.println(n);
            System.out.println("end:" + end);
            System.out.println();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (n <= end) {
                System.out.println("jinru");
                int max = (int) (Math.pow(10, i + 1) - Math.pow(10, i));
                System.out.println("max:" + max);
                for (int j = 0; j < max; j++) {
                    start += (i + 1) * (j + 1);
                    System.out.println("start:" + start);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (n <= start) {
                        Num = (int) Math.pow(10, i) + j;
                        Num = (int) (Num / Math.pow(10, start - n));
                        return Num % 10;
                    }
                }
                break;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int a = 2147483647;
        System.out.println(findNthDigit(a));

    }

}
