package design.proxy;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class ProxyTest {
    public static void main(String[] args) {
        Sourceable sourceable = new Proxy();
        sourceable.method();
    }
}
