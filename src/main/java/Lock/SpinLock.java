package Lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by zgl
 * Date: 2017/4/25.
 * Email: gaoleizhou@gmail.com
 * Desc: 自旋锁, there are some problem when more, 不可重入
 */
class SpinLock {
    private AtomicReference<Thread> owner = new AtomicReference<>();

    /**
     * 获得锁(不可重入)
     */
    public void lock() {
        Thread current = Thread.currentThread();
        while (!owner.compareAndSet(null, current)) {
            System.out.println("抢占CPU : " + Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
        }
        System.out.println("获得锁 : " + Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
    }

    /**
     * 释放锁
     */
    public void unlock() {
        Thread current = Thread.currentThread();
        owner.compareAndSet(current, null);
        System.out.println("释放锁 : " + Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
    }
}
