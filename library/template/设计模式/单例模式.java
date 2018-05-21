package 设计模式;

public class 单例模式 {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.newInstance();
        Singleton2 singleton2 = Singleton2.newInstance();
        Singleton3 singleton3 = Singleton3.newInstance();
        Singleton4 singleton4 = Singleton4.newInstance();
    }
}

//饿汉式
class Singleton1 {
    private Singleton1() {}
    private static Singleton1 instance = new Singleton1();
    public static Singleton1 newInstance() {
        return instance;
    }
}

//懒汉式
class Singleton2 {
    private Singleton2() {}
    private volatile static Singleton2 instance;
    public static Singleton2 newInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

//静态内部类
class Singleton3 {
    private Singleton3() {}
    private static class Inner {
        private static Singleton3 instance = new Singleton3();
    }
    public static Singleton3 newInstance() {
        return Inner.instance;
    }
}

//枚举类
class Singleton4 {
    private Singleton4() {}
    private enum Inner {
        element;
        Singleton4 instance;
        Inner() {
            instance = new Singleton4();
        }
    }
    public static Singleton4 newInstance() {
        return Inner.element.instance;
    }

}

