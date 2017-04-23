package design.proxy;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class Proxy implements Sourceable {
    private Source source;

    public Proxy() {
        super();
        this.source = new Source();
    }

    public void method() {
        before();
        source.method();
        after();
    }

    private void before() {
        System.out.println("before proxy.");
    }

    private void after() {
        System.out.println("after proxy.");
    }
}
