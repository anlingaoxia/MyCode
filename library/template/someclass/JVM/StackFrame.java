package someclass.JVM;

public class StackFrame {
    public void foo(int x) {
        if (x > 5) {
            long a = 0;
            long b = 1;
            long c = 2;
        } else {
            String a = "0";
            String b = "1";
            String c = "2";
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(12));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(12 & 5);
    }
}
