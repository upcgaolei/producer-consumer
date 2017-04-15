package design.factory;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class MailSender implements Sender {

    public void send() {
        System.out.println("Current is mail sender");
    }

}
