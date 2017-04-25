package Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zgl
 * Date: 2017/4/25.
 * Email: gaoleizhou@gmail.com
 * Desc: 验证ReentrantLock是可重入锁
 */
public class ReentrantLockTest implements Runnable {

    ReentrantLock lock = new ReentrantLock();

    public void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
            set();
        } finally {
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();

        new Thread(test, "线程A").start();
        new Thread(test, "线程B").start();
        new Thread(test, "线程C").start();
    }
}
/**
 10:线程A
 10:线程A
 11:线程B
 11:线程B
 12:线程C
 12:线程C
 */
