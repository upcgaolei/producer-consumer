package lock;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    private static void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        deadLock();
    }
}
