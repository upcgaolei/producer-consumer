package thread;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by 周高磊
 * Date: 2017/4/26.
 * Email: gaoleizhou@gmail.com
 * Desc: 同步屏障CyclicBarrier
 */
public class CyclicBarrierTest {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                }
                System.out.println(1);
            }
        }).start();

        try {
            cyclicBarrier.await();
        } catch (Exception e) {
        }

        System.out.println(2);
    }

}
