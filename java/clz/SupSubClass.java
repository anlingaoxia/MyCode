package clz;

public class SupSubClass {
    int a = 0;
    static int b = 1;
    final int c = 2;
    final static int d = 3;

    public static void main(String[] args) {
        SupSubClass clz1 = new SupSubClass();
        NewSubClass clz2 = new NewSubClass();
        NewSubClass2 clz3 = new NewSubClass2();
        System.out.println(clz1.a);
        System.out.println(clz1.b);
        System.out.println(clz1.c);
        System.out.println(clz1.d);
        System.out.println("=====");
        System.out.println(clz2.a);
        System.out.println(clz2.b);
        System.out.println(clz2.c);
        System.out.println(clz2.d);
        System.out.println("=====");
        System.out.println(clz3.a);
        System.out.println(clz3.b);
        System.out.println(clz3.c);
        System.out.println(clz3.d);
        System.out.println("=====");
        clz2.print();
        clz3.print();
    }
}

class NewSubClass extends SupSubClass {
    int a = 10;
    static int b = 11;
    final int c = 12;
    final static int d = 13;

    public void print() {
        System.out.println("=====");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}

class NewSubClass2 extends SupSubClass {
    public void print() {
        System.out.println("=====");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
