package thread;

/**
 * Created by 周高磊
 * Date: 2017/5/2.
 * Email: gaoleizhou@gmail.com
 * Desc:
 */
public class ConcurrencyTest {
    private static final long count = 1000001;

    /**
     * 并发
     * @throws InterruptedException
     */
    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for(int i = 0; i < count; i ++) {
                    a = a + 5;
                }
            }
        });

        thread.start();

        int b = 0;
        for(int i = 0; i < count; i ++) {
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency : " + time + "ms, b=" + b);
    }

    /**
     * 串行
     */
    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for(int i = 0; i < count; i ++) {
            a = a + 5;
        }
        int b = 0;
        for(int i = 0; i < count; i ++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial : " + time + "ms, b=" + b);
    }


    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }
}
