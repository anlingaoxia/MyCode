package thread;

import java.util.ArrayList;
import java.util.List;
//PrintModelThread 一个数据模型，存储需要打印的字符串，自身是个打印线程
//PrintChar 向PrintModel中写入打印的Char的线程
//PrintNum 向PrintModel中写入打印的Num的线程

public class PrintModelThread extends Thread {
    public List<String> mPrint;
    public boolean mLastIsNum = true;
    public int mNum;
    public int mChar;

    PrintModelThread() {
        mPrint = new ArrayList<>();
        Class<PrintModelThread> clz = PrintModelThread.class;
    }

    public synchronized void add(String s) throws InterruptedException {
        if (mLastIsNum) {
            if (Thread.currentThread() instanceof PrintNum) {
                System.out.println("mLastIsNum:" + mLastIsNum + " PrintNum thread wait");
                wait();
            } else {
                mPrint.add(s);
                mLastIsNum = false;
                mChar++;
//                System.out.println("add:" + s);
//                System.out.println("mChar:" + mChar);
//                Thread.sleep(50);
                notifyAll();
            }
        } else {
            if (Thread.currentThread() instanceof PrintChar) {
                System.out.println("mLastIsNum:" + mLastIsNum + " PrintChar thread wait");
                wait();
            } else {
                mPrint.add(s);
                mLastIsNum = true;
                mNum++;
//                System.out.println("add:" + s);
//                System.out.println("mNum:" + mNum);
//                Thread.sleep(50);
                notifyAll();
            }
        }
    }

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        int lastIndex = 0;
        while (System.currentTimeMillis() - lastTime < 2000) {
            int nowLastIndex = mPrint.size() - 1;
            if (!mPrint.isEmpty() && nowLastIndex > lastIndex) {
                for (int i = lastIndex; i <= nowLastIndex; i++) {
                    System.out.println(mPrint.get(i));
                }
                lastTime = System.currentTimeMillis();
                lastIndex = nowLastIndex;
            } else {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("model over");
    }

    static class PrintChar extends Thread {
        PrintModelThread mModel;

        PrintChar(PrintModelThread model) {
            mModel = model;
        }

        @Override
        public void run() {
            while (mModel.mChar < 26) {
                char c = (char) (mModel.mChar + 'a');
                try {
                    mModel.add(new String(new char[]{c}));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (mModel.mChar < 52) {
                char c = (char) (mModel.mChar - 26 + 'A');
                try {
                    mModel.add(new String(new char[]{c}));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("PrintNum over");
        }
    }

    static class PrintNum extends Thread {
        PrintModelThread mModel;

        PrintNum(PrintModelThread model) {
            mModel = model;
        }

        @Override
        public void run() {
            while (mModel.mNum < 52) {
                String s = String.valueOf(mModel.mNum + 1);
                try {
                    mModel.add(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("PrintChar over");
        }
    }

    public static void main(String[] args) {
        PrintModelThread model = new PrintModelThread();
        PrintNum printNum = new PrintNum(model);
        PrintChar printChar = new PrintChar(model);
        model.start();
        printNum.start();
        printChar.start();
    }
}
