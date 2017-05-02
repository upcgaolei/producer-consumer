package atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 周高磊
 * Date: 2017/5/2.
 * Email: gaoleizhou@gmail.com
 * Desc:
 */
public class Counter {

    private AtomicInteger atomicI = new AtomicInteger(0);

    private int i = 0;

    /**
     * 非线程安全计数器
     */
    private void count() {
        i ++;
    }

    /**
     * 线程安全计数器,基于CAS实现
     */
    private void safeCount() {
        for(;;) {
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i, ++i);
            if(suc) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        final Counter counter = new Counter();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for(int j = 0; j < 100; j ++) {
            Thread t = new Thread(() -> {
                counter.count();
                counter.safeCount();
            });
            ts.add(t);
        }

        ts.stream().forEach(Thread::start);

        ts.stream().forEach(meta -> {
            try {
                meta.join();
            }catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println(counter.i);
        System.out.println(counter.atomicI.get());
        System.out.println(System.currentTimeMillis() - start);
    }
}
