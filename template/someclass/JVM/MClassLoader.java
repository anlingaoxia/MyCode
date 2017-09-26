package someclass.JVM;


public class MClassLoader {
    public static ClassLoader getCL() {
        return null;
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Class t = getCL().loadClass("someclass.JVM.TestClass");

    }

}
