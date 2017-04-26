package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by 周高磊
 * Date: 2017/4/26.
 * Email: gaoleizhou@gmail.com
 * Desc:
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 20;

    private Executor executor = Executors.newFixedThreadPool(THREAD_COUNT);

    private Semaphore semaphore = new Semaphore(10);

    public void count() {
        for(int i = 0; i < THREAD_COUNT; i ++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    semaphore.acquire();
                    System.out.println("1");
                    semaphore.release();
                }
            });
        }
    }

    public static void main(String[] args) {

    }
}
