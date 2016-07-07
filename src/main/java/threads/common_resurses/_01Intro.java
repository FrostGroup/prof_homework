package threads.common_resurses;

import static java.lang.System.currentTimeMillis;

/**
 * Created by Alex on 13.06.2016.
 */
public class _01Intro {
    public static void main(String[] args) {
        
        Container container = new Container();

        long start = currentTimeMillis();

        for (int i = 0; i < 1; i++) {
            Thread thread1 = new Thread(new IncThread(container, 1000000));
            thread1.start();
            Thread thread2 = new Thread(new DecThread(container, 1000000));
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long end = currentTimeMillis();

            System.out.println("time: " + (end - start));

            System.out.println(container.getCount());

        }
    }
}

class IncThread implements Runnable{

    private Container container;
    private int operationCount;

    public IncThread(Container container, int operationCount){
        this.container = container;
        this.operationCount = operationCount;

    }

    @Override
    public void run() {
        for (int i = 0; i < operationCount; i++) {
            container.inc();
        }
    }
}

class DecThread implements Runnable{

    private Container container;
    private int operationCount;

    public DecThread(Container container, int operationCount){
        this.container = container;
        this.operationCount = operationCount;

    }

    @Override
    public void run() {
        for (int i = 0; i < operationCount; i++) {
            container.decr();
        }
    }
}


class Container{
    private volatile int count;

    public synchronized void inc(){
        count++;
    }

    public synchronized void decr(){
        count--;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}