package thread.creation;

import java.util.concurrent.Callable;

public class CreateThread {
    public static void main(String[] args) {
        Runnable r1 = () -> {

        };
        Thread t1 = new Thread();

    }
}


class CreateThread2 extends Thread {
    @Override
    public void run() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CreateThread3 implements Callable {

    @Override
    public Object call() throws Exception {
        return null;
    }
}

