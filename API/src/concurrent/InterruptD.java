package concurrent;

public class InterruptD {
    public static void main(String[] args){
        MyRunnable1 run1 = new MyRunnable1();
        Thread t1 = new Thread(run1);
        MyRunable2 run2 = new MyRunable2();
        Thread t2 = new Thread(run2);
        t1.start();
        t2.start();

        for(int i = 0; i < 50; i ++){
            System.out.println(Thread.currentThread().getName() + "--" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if( i == 20) {
                t1.interrupt();     // using interrupt() method
                run2.flag = false;  // using a flag
            }
        }
    }
}

class MyRunnable1 implements Runnable {

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            if (Thread.interrupted()) {                      // interrupted() method
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();          // interrupt() again
            }

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class MyRunable2 implements Runnable {
    public boolean flag = true;                              // flag
    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "====" + (i++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
