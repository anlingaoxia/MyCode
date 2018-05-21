package src;

public class 数值的整数次方 {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent < 0) {
            return 1 / PowerHelper(base, -exponent);
        } else {
            return PowerHelper(base, exponent);
        }
    }

    public double PowerHelper(double base, int exponent) {
        if (exponent == 1) {
            return base;
        }
        int r = exponent % 2;
        double rlt = Power(base, exponent / 2);
        if (r == 0) {
            return rlt * rlt;
        } else {
            return rlt * rlt * base;
        }
    }
}
