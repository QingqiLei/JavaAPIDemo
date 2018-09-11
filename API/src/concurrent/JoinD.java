package concurrent;

public class JoinD {
    public static void main(String[] args){
        MyRunnable run = new MyRunnable();
        Thread t2 = new Thread(run);
        t2.start();
        for(int i = 0; i < 50; i ++){
            System.out.println(Thread.currentThread().getName() + "--" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if( i == 20){
                try {
                    t2.join();                        // let t2 run prioritized
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 50; i ++){
            if(Thread.interrupted())
                break;
            System.out.println(Thread.currentThread().getName()+"-"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
