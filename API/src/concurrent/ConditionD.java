package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionD {
    private volatile int value = 1;

    private Lock lock = new ReentrantLock();
    private Condition Condition456 = lock.newCondition();
    private Condition Condition789 = lock.newCondition();
    private Condition Condition101112 = lock.newCondition();

    class ThreadA implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("首先输出1-3");
                while (value <= 3)
                    System.out.println(value++);
                Condition456.signal();
            } finally {
                lock.unlock();

            }

            try {
                lock.lock();
                while (value <= 6) {
                    System.out.println("value <= 6");
                    Condition789.await();
                }
                System.out.println("输出7-9");

                while (value <= 9)
                    System.out.println(value++);
                Condition101112.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    class ThreadB implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                while (value <= 3) {
                    System.out.println("value <= 3");
                    Condition456.await();
                }
                lock.lock();
                System.out.println("输出4-6");
                while (value <= 6)
                    System.out.println(value++);

                Condition789.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


            try {
                lock.lock();
                while (value <= 9) {
                    System.out.println("value <= 9");
                    Condition101112.await();
                }
                lock.lock();
                System.out.println("输出10-12");
                while (value <= 12) {
                    System.out.println(value++);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ConditionD test = new ConditionD();
        Thread ThreadA = new Thread(test.new ThreadA());
        Thread ThreadB = new Thread(test.new ThreadB());
        ThreadA.start();
        ThreadB.start();

    }
}
