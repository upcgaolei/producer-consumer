package Lock;

/**
 * Created by zgl
 * Date: 2017/4/25.
 * Email: gaoleizhou@gmail.com
 * Desc: 验证Synchronized是可重入锁
 */
public class SynchronizedTest implements Runnable {

    public synchronized void get() {
        System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
        //内层函数依然获取该对象锁 Monitor
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();

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
