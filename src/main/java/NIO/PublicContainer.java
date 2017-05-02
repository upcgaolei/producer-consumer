package nio;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class PublicContainer {

    private int apple = 0;

    public synchronized void increase() {
        while(apple == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        apple++;
        System.out.println("Producer produce one apple : " + apple);
        notify();
    }

    public synchronized void decrease() {
        while(apple == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        apple--;
        System.out.println("Consumer consume one apple : " + apple);
        notify();
    }
}
