package Lock;

/**
 * Created by zgl
 * Date: 2017/4/25.
 * Email: gaoleizhou@gmail.com
 * Desc: 可重入的自旋锁测试
 */
public class UpgradeSpinLockTest implements Runnable {

    private UpgradeSpinLock upgradeSpinLock;

    static int sum;

    public UpgradeSpinLockTest(UpgradeSpinLock upgradeSpinLock) {
        this.upgradeSpinLock = upgradeSpinLock;
    }

    @Override
    public void run() {
        upgradeSpinLock.lock();
        upgradeSpinLock.lock();
        sum ++;
        upgradeSpinLock.unlock();
        upgradeSpinLock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        UpgradeSpinLock upgradeSpinLock = new UpgradeSpinLock();

        for(int i = 0; i < 100; i ++) {
            UpgradeSpinLockTest upgradeSpinLockTest = new UpgradeSpinLockTest(upgradeSpinLock);
            new Thread(upgradeSpinLockTest).start();
        }

        System.out.println("Before : " + Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
        System.out.println("System current time (before) : " + System.currentTimeMillis());
        Thread.currentThread().sleep(1000);
        System.out.println("System current time (after) : " + System.currentTimeMillis());
        System.out.println("After : " + Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
        System.out.println("sum = " + sum);
    }
}
