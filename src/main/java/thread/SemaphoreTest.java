package thread;

import java.util.Stack;
import java.util.concurrent.*;

/**
 * Created by 周高磊
 * Date: 2017/4/26.
 * Email: gaoleizhou@gmail.com
 * Desc:
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 20;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for(int i = 0; i < THREAD_COUNT; i ++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("当前线程 : " + Thread.currentThread().getName());
                        System.out.println("剩余可用信号量 : " + semaphore.availablePermits());
                        System.out.println("是否有线程队列等待 : " + semaphore.hasQueuedThreads());
                        semaphore.acquire();
                        System.out.println("save data");
                        semaphore.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        threadPool.shutdown();
    }
}
