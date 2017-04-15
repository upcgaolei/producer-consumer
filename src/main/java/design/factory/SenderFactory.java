package design.factory;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class SenderFactory {

    public Sender produce(String type) {
        if("mail".equals(type)) {
            return new MailSender();
        } else if("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("please input correct type!");
            return null;
        }
    }

    public SmsSender produceSms() {
        return new SmsSender();
    }

    public MailSender produceMail() {
        return new MailSender();
    }

    public static SmsSender staticProduceSms() {
        return new SmsSender();
    }

    public static MailSender staticProduceMail() {
        return new MailSender();
    }

}
