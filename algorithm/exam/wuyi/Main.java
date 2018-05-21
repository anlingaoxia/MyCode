package wuyi;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    static volatile boolean over = false;

    public static void main(String[] args) {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        CountThread t1 = new CountThread(queue);
        CountThread t2 = new CountThread(queue);
        CountThread t3 = new CountThread(queue);
        t1.start();
        t2.start();
        t3.start();
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (sc.hasNext() && count < 3) {
            count++;
            try {
                queue.put(sc.nextLine());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(count);
        }
        sc.close();
        over = true;
        while (!t1.mOver || !t2.mOver || t3.mOver) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(t1.mCount + t2.mCount + t3.mCount);
    }

    static class CountThread extends Thread {
        BlockingQueue<String> mQueue;
        public int mCount = 0;
        public boolean mOver = false;

        public CountThread(BlockingQueue<String> queue) {
            mQueue = queue;
        }

        @Override
        public void run() {
            while (!over) {
                try {
                    count(mQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mOver = true;
        }

        public void count(String str) {
            for (int i = 0; i < str.length() - 2; ) {
                if (str.charAt(i) == 'u' && str.charAt(i + 1) == '5' && str.charAt(i + 2) == '1') {
                    mCount++;
                    i += 3;
                } else i++;
            }
        }
    }


}
