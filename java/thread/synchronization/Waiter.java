package thread.synchronization;

public class Waiter {
    public synchronized void runWait() {
        System.out.println(Thread.currentThread() + " runWait start");
        try {
            Thread.currentThread().interrupt();
            Thread.interrupted();
            wait(500);
            System.out.println(Thread.currentThread().getName() + " over State: " + Thread.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " runWait over");
    }

    public synchronized void runNormal() {
        System.out.println(Thread.currentThread() + " runNormal start");
        while (true) {
            System.out.println(Thread.currentThread().getName() + " State: " + Thread.currentThread().getState());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(Thread.currentThread() + " runNormal over");
    }
    static int runTime = 0;
    public static void main(String[] args) {
        Waiter w = new Waiter();
        WaitThread wt = new WaitThread(w);

        Thread t = new Thread(() -> {
            while (runTime != 100) {
                try {
                    System.out.println("wt State: " + wt.getState().toString());
                    runTime++;
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        wt.start();
        t.start();
    }
}

class WaitThread extends Thread {
    Waiter w = null;
    public WaitThread(Waiter w) {
        this.w = w;
    }
    @Override
    public void run() {
        w.runWait();
        w.runNormal();
    }
}
