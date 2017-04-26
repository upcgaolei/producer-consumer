package thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 周高磊
 * Date: 2017/4/26.
 * Email: gaoleizhou@gmail.com
 * Desc: CountDownLatch.await()方法会阻塞当前线程,直到N变为零
 */
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("parser1 finish");
            countDownLatch.countDown();
            System.out.println("parser2 finish");
            countDownLatch.countDown();
        }).start();

        System.out.println(Thread.currentThread().getName());
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName());

        System.out.println("all parser finish");
    }
}
