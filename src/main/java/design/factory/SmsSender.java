package design.factory;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class SmsSender implements Sender {

    public void send() {
        System.out.println("Current is sms sender");
    }

}
