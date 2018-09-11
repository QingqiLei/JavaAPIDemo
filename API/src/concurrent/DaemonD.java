package concurrent;

public class DaemonD {
    public static void main(String[] args){
        MyRunnable4 mr4 = new MyRunnable4();
        Thread t = new Thread(mr4);
        t.setDaemon(true);
        System.out.println(t.isAlive());
        t.start();
        System.out.println(t.isAlive());
        t.setPriority(Thread.MAX_PRIORITY);
        t.setName("hahhaha");
        for(int i = 0; i < 50; i ++){
            System.out.println("main-"+i);
            if( i ==5)
                Thread.yield();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable4 implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 50; i ++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyRunnable4 " +i);

        }

    }
}
