package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/16
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class Network {
    public static void main(String[] args) throws UnknownHostException {
        String host = "www.baidu.com";
        InetAddress address = InetAddress.getByName(host);
        byte[] byteAddress = address.getAddress();
        String address1 = address.getHostAddress();
        String address2 = address.getHostName();
        System.out.println(byteAddress);
        System.out.println(address1);
        System.out.println(address2);

        InetAddress[] addresses = InetAddress.getAllByName(host);
        for(InetAddress meta : addresses) {
            System.out.println(meta.getHostAddress());
        }

        InetAddress localAddress= InetAddress.getLocalHost();
        System.out.println("Local Host : " + localAddress.getHostAddress());
    }
}
