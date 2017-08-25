package transform.easy2;

public class Sqrt {
    public static double mySqrt(int x) {
        if (x < 0) return 0;
        double err = 1e-4;
        double t = x;
        while (Math.abs(t - x / t) > err * t)
            t = (x / t + t) / 2.0;
        return t;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(3));
        System.out.println(Math.sqrt(3));
    }

}
