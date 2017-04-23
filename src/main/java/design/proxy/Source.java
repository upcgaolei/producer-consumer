package design.proxy;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class Source implements Sourceable {
    public void method() {
        System.out.println("the original method.");
    }
}
