package lock;

/**
 * Created by zgl
 * Date: 2017/4/25.
 * Email: gaoleizhou@gmail.com
 * Desc: 不可重入的自旋锁测试
 */
public class SpinLockTest implements Runnable {

    static int sum;

    private SpinLock spinLock;

    public SpinLockTest(SpinLock spinLock) {
        this.spinLock = spinLock;
    }

    @Override
    public void run() {
        spinLock.lock();
        sum ++;
        spinLock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLock spinLock = new SpinLock();
        for(int i = 0; i < 100; i ++) {
            SpinLockTest test = new SpinLockTest(spinLock);
            new Thread(test).start();
        }
        System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
        Thread.currentThread().sleep(1000);
        System.out.println(sum);
    }
}
