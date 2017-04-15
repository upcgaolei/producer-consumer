import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class ProducerConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        int numProducers = 4;
        int numConsumers = 3;
        BlockingQueue<Object> myQueue = new LinkedBlockingDeque<Object>(20);

        for(int i = 0; i < numProducers; i++) {
            new Thread(new Producer(myQueue)).start();
        }

        for(int i = 0; i < numConsumers; i++) {
            new Thread(new Consumer(myQueue)).start();
        }

        Thread.sleep(10 * 1000);

        System.exit(0);
    }
}
