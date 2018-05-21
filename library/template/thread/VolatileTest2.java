package thread;

public class VolatileTest2 {
    static class AAA {
        volatile static String x = "123";
    }


    public static void main(String[] args) {
        AAA aaa = new AAA();


        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                String a = aaa.x;
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                String b = aaa.x;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

    }
}
