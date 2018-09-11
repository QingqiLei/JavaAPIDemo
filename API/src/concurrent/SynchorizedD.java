package concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class SynchorizedD {
    public static void main(String[] args) {
        MyRunnable5 mr5 = new MyRunnable5();
        Thread t1 = new Thread(mr5);
        Thread t2 = new Thread(mr5);
        t1.start();
        t2.start();
    }
}

class MyRunnable5 implements Runnable {

    private volatile int ticket = 10;
    private Object obj = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            synchronized (obj) {
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println("there is " + ticket + " tickets remaining");
                    ticket--;
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
//            method();
//            method2();

        }
    }

    private synchronized void method() {
        if (ticket > 0) {
            System.out.println("there is " + ticket + " tickets remaining");
            ticket--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    ReentrantLock lock = new ReentrantLock();

    private void method2() {
        if (ticket > 0) {
            lock.lock();
            try {
                System.out.println("there is " + ticket + " tickets remaining");
                ticket--;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
