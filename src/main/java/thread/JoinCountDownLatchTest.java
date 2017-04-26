package thread;

/**
 * Created by 周高磊
 * Date: 2017/4/26.
 * Email: gaoleizhou@gmail.com
 * Desc: join用于让当前线程等待join线程执行结束
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(() -> {
            System.out.println("parser1 finish");
        });

        Thread parser2 = new Thread(() -> {
            System.out.println("parser2 finish");
        });

        System.out.println(Thread.currentThread().getName());
        parser1.start();
        System.out.println(Thread.currentThread().getName());
        parser2.start();
        System.out.println(Thread.currentThread().getName());
        parser1.join();
        System.out.println(Thread.currentThread().getName());
        parser2.join();
        System.out.println(Thread.currentThread().getName());
        System.out.println("all parser finish");
    }
}
/**
 main
 parser1 finish
 main
 main
 parser2 finish
 main
 main
 all parser finish
 */
