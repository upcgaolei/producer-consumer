package Lock;

/**
 * Created by zhougaolei on 2017/4/21.
 */
public class SynchronizedDemo1 {
    public synchronized void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public synchronized void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }

    public static int bytes2int(byte[] b, int off)
    {
        return ((b[off + 3] & 0xFF) << 0) +
                ((b[off + 2] & 0xFF) << 8) +
                ((b[off + 1] & 0xFF) << 16) +
                ((b[off + 0]) << 24);
    }

    public static int bytes2int(byte[] b)
    {
        return bytes2int(b, 0);
    }


    public static void main(String[] args) {

        System.out.println(SynchronizedDemo1.bytes2int(new byte[]{1, 1, 1, 1}));

        final SynchronizedDemo1 test = new SynchronizedDemo1();

        new Thread(new Runnable() {
            public void run() {
                test.method1();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                test.method2();
            }
        }).start();
    }
}
