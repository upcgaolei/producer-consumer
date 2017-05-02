package nio;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class Producer implements Runnable {

    private PublicContainer container;

    public Producer(PublicContainer container) {
        this.container = container;
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            container.increase();
        }
    }

}
