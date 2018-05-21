package thread.synchronization;

import java.util.ArrayList;
import java.util.List;

/*
写
 */
public class Counter {
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count = 0;

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    private boolean isEnd = false;

    public synchronized void increase() {
        System.out.println("States:");
        for (Thread t : tList) {
            System.out.println(t.getName() + " : " + t.getState());
        }
        setCount(getCount() + 1);
        if (count == 80) setEnd(true);
        System.out.println("currentThread:" + Thread.currentThread().getName() + "\t" + "count:" + getCount());
        try {
            System.out.println(Thread.currentThread().getName() + " notify");
            Thread.sleep(100);
            notify();
            System.out.println(Thread.currentThread().getName() + " wait");
//            wait();
            wait(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " before notify: ===");
        for (Thread t : tList) {
            System.out.println(t.getName() + " : " + t.getState());
        }
        notify();
        System.out.println(Thread.currentThread().getName() + " after notify: ===");
        for (Thread t : tList) {
            System.out.println(t.getName() + " : " + t.getState());
        }
        System.out.println(Thread.currentThread().getName() + " ================");
    }

    public static List<Thread>  tList = new ArrayList<>();
    public static void main(String[] args) {
        Counter c = new Counter();
        IncreaseThread t1 = new IncreaseThread(c);
        IncreaseThread t2 = new IncreaseThread(c);
        IncreaseThread t3 = new IncreaseThread(c);
        IncreaseThread t4 = new IncreaseThread(c);
        IncreaseThread t5 = new IncreaseThread(c);
        t1.setName("Thread1");
        t2.setName("Thread2");
        t3.setName("Thread3");
        t4.setName("Thread4");
        t5.setName("Thread5");
        tList.add(t1);
        tList.add(t2);
        tList.add(t3);
        tList.add(t4);
        tList.add(t5);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class IncreaseThread extends Thread {
    Counter c = null;
    public IncreaseThread(Counter c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (!c.isEnd()){
            System.out.println(getName() + " start increase");
            c.increase();
            System.out.println(getName() + " end increase");
        }
        System.out.println(getName() + " increase over");
    }
}
