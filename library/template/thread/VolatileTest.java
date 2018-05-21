package thread;

public class VolatileTest {
    static class Tmp {
        int newA = 0;

        private Tmp() {
            newA = 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        volatile static Tmp instance;

        public static Tmp get() {
            if (instance == null) {
                synchronized (VolatileTest.class) {
                    if (instance == null) {
                        instance = new Tmp();
                    }
                }
            }
            return instance;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                if (Tmp.get() != null) {
                    System.out.println("get1() != null");
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                if (Tmp.get() != null) {
                    System.out.println("get2() != null");
                }
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        Thread.sleep(500);
        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                while (thread2.isAlive()) {
                    System.out.println(thread2.getState().toString());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread2.start();
        new Thread(runnable3).start();
    }
}
