package array;

interface Incrementable{
    void increment();
}

class MyIncrementable {
    public void increment(){ System.out.println("Other Operarion"); }
    static void f(MyIncrementable mi){ mi.increment(); }
}

class Callee1 implements Incrementable{
    private int i = 0;
    public void increment(){
        i++;
        System.out.println(i);
    }
}

class Callee2 extends MyIncrementable{
    private int i = 0;
    public void increment(){
        super.increment();
        i++;
        System.out.println(i);
    }
    private class Closure implements Incrementable{
        public void increment(){
            Callee2.this.increment();
        }
    }
    Incrementable getCallbackReference(){
        return new Closure();
    }
}

class Caller{
    private Incrementable callbackReference;
    Caller(Incrementable cbn){ callbackReference = cbn; }
    void go(){ callbackReference.increment(); }
}

public class Callbacks {
    public static void main(String[] args){
//        Callee1 c1 = new Callee1();
//        Callee2 c2 = new Callee2();
//        MyIncrementable.f(c2);//O 1
//        Caller caller1 = new Caller(c1);
//        Caller caller2 = new Caller(c2.getCallbackReference());
//        caller1.go();//1
//        caller1.go();//2
//        caller2.go();//O 2
//        caller2.go();//O 3
        new C();
    }

}


class A {
    {
        System.out.println("A");
    }
    private class B {
        {
            System.out.println("B");
        }
    }
}

class C extends A {
    {
        System.out.println("C");
    }
}
