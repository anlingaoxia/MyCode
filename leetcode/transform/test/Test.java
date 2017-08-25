package transform.test;

public class Test {

    public static int get() {
        System.out.println("get");
        return 10;
    }

    public static void test() {
        for (int i = 0; i < get(); i++) {
            System.out.println(i);
        }
    }

    public int add(int a, int b) {
        while (b != 0) {
            int tempA = a ^ b;
            int tempB = (a & b) << 1;
            a = tempA;
            b = tempB;
        }
        return a;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(i + ":   ");
            int res = i & -i;
            System.out.print(res + "      ");
            System.out.println(Integer.toBinaryString(res));
            // System.out.println(Integer.toBinaryString(i));
        }
        // System.out.println(6 & -6);
        // System.out.println(6 & 0);
        // System.out.println(6 & 6);
        // System.out.println(Integer.toBinaryString(6));
        // System.out.println(Integer.toBinaryString(-6));

    }

}
