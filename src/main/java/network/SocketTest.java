package network;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/16
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class SocketTest {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket();
        s.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov", 13), 1000);
        InputStream inputStream = s.getInputStream();
        Scanner in = new Scanner(inputStream);
        while(in.hasNext()) {
            String line = in.nextLine();
            System.out.println(line);
        }
    }
}
