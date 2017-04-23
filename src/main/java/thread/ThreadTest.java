package thread;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/18
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println(1);
            }
        });

        System.out.println(thread.isAlive());
        System.out.println(thread.isInterrupted());

        thread.start();

        System.out.println(thread.isAlive());
        System.out.println(thread.isInterrupted());

        thread.run();

    }
}
