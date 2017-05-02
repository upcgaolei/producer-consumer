package nio;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        PublicContainer container = new PublicContainer();
        Producer producer = new Producer(container);
        Consumer consumer = new Consumer(container);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
