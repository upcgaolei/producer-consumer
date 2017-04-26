package thread;

import java.util.HashMap;

/**
 * Created by zgl
 * Date: 2017/4/26.
 * Email: gaoleizhou@gmail.com
 * Desc: 验证HashMap非线程安全
 */
public class ThreadNotSafeHashMap {
    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> hashMap = new HashMap<>();

        new Thread(() -> {
            for(int i = 0; i < 2500; i ++) {
                hashMap.put(String.valueOf(i), String.valueOf(i));
            }
        }).start();

        new Thread(() -> {
            for(int i = 2500; i < 5000; i ++) {
                hashMap.put(String.valueOf(i), String.valueOf(i));
            }
        }).start();

        Thread.sleep(1000);

        for(int i = 0; i < 5000; i ++) {
            if(!String.valueOf(i).equals(hashMap.get(String.valueOf(i)))) {
                System.out.println(String.valueOf(i) + ":" + hashMap.get(String.valueOf(i)));
            }
        }
    }
}
