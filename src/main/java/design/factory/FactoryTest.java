package design.factory;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc: Factory Design
 */
public class FactoryTest {
    public static void main(String[] args) {
        SenderFactory factory = new SenderFactory();

        Sender mailSender = factory.produce("mail");
        mailSender.send();

        Sender smsSender = factory.produce("sms");
        smsSender.send();

        Sender mailSender1 = factory.produceMail();
        mailSender1.send();

        Sender smsSender1 = factory.produceSms();
        smsSender1.send();

        Sender mailSender2 = SenderFactory.staticProduceMail();
        mailSender2.send();

        Sender smsSender2 = SenderFactory.staticProduceSms();
        smsSender2.send();
    }
}
