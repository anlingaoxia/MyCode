package transform.easy;

public class Ugly_Number {
    public static boolean isUgly(int num) {
        if(num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        if(num == 1) {
            return true;
        }
        return false;
    }

    // wrong
    public static boolean isUgly2(int num) {
        if (num == 1 || num == 2 || num == 3 || num == 5) {
            return true;
        } else if (isPrime(num)) {
            return false;
        }
        boolean onlyTwo = true;
        boolean onlyThree = true;
        boolean onlyFive = true;
        boolean has = false;
        if (num % 2 == 0) {
            onlyTwo = isUgly2(num / 2);
            has = true;
        }
        if (num % 3 == 0) {
            onlyThree = isUgly2(num / 3);
            has = true;
        }
        if (num % 5 == 0) {
            onlyFive = isUgly2(num / 5);
            has = true;
        }

        return has ? onlyTwo && onlyThree && onlyFive : false;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++) {
            System.out.println(i+ ":   " + isUgly(i));
        }

    }

}
