package thread;

import sun.jvm.hotspot.runtime.Threads;

/**
 * Created by zhougaolei on 2017/4/20.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread thread = new MyThread("mythread");

        thread.run();

        thread.start();
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}
