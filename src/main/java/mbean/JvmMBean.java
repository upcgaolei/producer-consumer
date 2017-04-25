package mbean;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * Created by zgl
 * Date: 2017/4/23.
 * Email: gaoleizhou@gmail.com
 */
public class JvmMBean {
    public static void main(String[] args) {
        try {
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            System.out.println(mBeanServer);
            RuntimeMXBean runtimeMXBean = ManagementFactory.newPlatformMXBeanProxy(mBeanServer, "java.lang:type=Runtime", RuntimeMXBean.class);
            System.out.println(runtimeMXBean);
        } catch (Exception e) {

        }
    }
}
