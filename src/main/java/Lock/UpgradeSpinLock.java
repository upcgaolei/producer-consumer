package Lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by zgl
 * Date: 2017/4/25.
 * Email: gaoleizhou@gmail.com
 * Desc: 可重入的自旋锁
 */
public class UpgradeSpinLock {

    private AtomicReference<Thread> owner = new AtomicReference<>();

    private int count = 0;

    /**
     * 获取锁
     */
    public void lock() {
        Thread currentThread = Thread.currentThread();
        if(currentThread == owner.get()) {
            count ++;
            System.out.println("count : " + count);
            return;
        }
        //只要不满足条件Condition, 就一直循环
        while(!owner.compareAndSet(null, currentThread)) {
            System.out.println("抢占CPU : " + Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
        }
        System.out.println("获得锁 : " + Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
    }

    /**
     * 释放锁
     */
    public void unlock() {
        Thread currentThread = Thread.currentThread();
        if(currentThread == owner.get()) {
            if(count > 0) {
                count --;
                System.out.println("count : " + count);
            } else {
                owner.compareAndSet(currentThread, null);
                System.out.println("释放锁 : " + Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
            }
        }
    }
}
