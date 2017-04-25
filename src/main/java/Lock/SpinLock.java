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

    public void lock() {
        Thread current = Thread.currentThread();
        while (!owner.compareAndSet(null, current)) {}
        System.out.println(current.getId());
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        System.out.println(current.getId());
        owner.compareAndSet(current, null);
    }
}
