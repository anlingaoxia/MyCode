package transform.easy2;

public class Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        
        
        
        
        
        
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        if (num < 1) {
            return false;
        } else if (num == 1) {
            return true;
        }
        int count = 1;
        while (num >= 10) {
            num /= 10;
            count++;
        }

        for (int i = 1; i <= Math.pow(10, count); i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
}
