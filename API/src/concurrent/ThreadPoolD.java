package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolD {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        MyRunnable6 mr = new MyRunnable6();
        es.execute(mr);
        es.execute(mr);
        es.execute(mr);
        es.execute(mr);
        es.shutdown();

    }
}

class MyRunnable6 implements Runnable {
    int times = 50;

    @Override
    public void run() {
        synchronized (this) {
        for (; times > 0; times--) {
//            synchronized (this) {
                System.out.println("run-" + (51 - times));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
