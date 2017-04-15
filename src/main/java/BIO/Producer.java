package BIO;

import java.util.concurrent.BlockingQueue;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc: Producer
 */
public class Producer implements Runnable {

    protected BlockingQueue<Object> blockingQueue;

    public Producer(BlockingQueue<Object> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        try {
            while (true) {
                Object justProduced = getResource();
                blockingQueue.put(justProduced);
                System.out.println("Produced resource -- Queue size now = " + blockingQueue.size());
            }
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted");
        }
    }

    /**
     * 获取
     * @return Object
     */
    Object getResource() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Producer read interrupted");
        }
        return new Object();
    }
}
