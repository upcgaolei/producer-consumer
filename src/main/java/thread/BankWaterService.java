package thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by 周高磊
 * Date: 2017/4/26.
 * Email: gaoleizhou@gmail.com
 * Desc: CyclicBarrier(int parties, Runnable barrierAction) 用于线程到达屏障时, 优先执行barrierAction
 */
public class BankWaterService implements Runnable {

    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);

    private Executor executor = Executors.newFixedThreadPool(4);

    public void count() {
        for(int i = 0; i < 4; i ++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    try{
                        cyclicBarrier.await();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for(Map.Entry<String, Integer> entry : sheetBankWaterCount.entrySet()) {
            result = result + entry.getValue();
        }
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }

}
/**
 4
 pool-1-thread-4
 pool-1-thread-1
 pool-1-thread-2
 pool-1-thread-3
 */
