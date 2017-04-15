import java.util.concurrent.BlockingQueue;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc: Consumer
 */
public class Consumer implements Runnable {

    protected BlockingQueue<Object> blockingQueue;

    protected Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        try {
            while (true) {
                Object object = blockingQueue.take();
                System.out.println("Consumed resource -- Queue size now = " + blockingQueue.size());
                take(object);
            }
        } catch (InterruptedException e) {
            System.out.println("consumer interrupted");
        }
    }

    void take(Object object) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Consumer read interrupted");
        }
        System.out.println("Consuming object" + object);
    }
}
