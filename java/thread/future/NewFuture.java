package thread.future;

import java.util.concurrent.locks.LockSupport;

public class NewFuture {
    public static void main(String[] args) {
        Thread t = new Thread();
        LockSupport.park();//获取许可
        LockSupport.unpark(t);//释放许可
        t.interrupt();


    }
}