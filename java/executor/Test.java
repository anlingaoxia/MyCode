package executor;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Test {
    public void get() {
        ExecutorService pool = Executors.newCachedThreadPool();
        Runnable target = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "  i:" + i);
            }
        };
        System.out.println("start1");
        pool.submit(target);
        System.out.println("start2");
        pool.submit(target);
        System.out.println("start shutdown");
        pool.shutdown();

    }

    public static void main(String[] args) {
//        int h;
//        int c = (h = 4) ^ (h >>> 16);
//        System.out.println(c);
        int b = 8;
        int a = (b = 4) & (4);
        System.out.println(a);

    }
}
