package design.singleton;

import java.util.Objects;

/**
 * Copyright (c) 2017 zhougaolei
 * Date:17/4/15
 * Author: <a href="upcgaolei@qq.com">周高磊</a>
 * Desc:
 */
public class Singleton {

    public static Singleton instance = null;

    public Singleton() {
    }

    public static Singleton getInstance() {
        if(instance == null) {
            initInstance();
        }
        return instance;
    }

    private static synchronized void initInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
    }

    public Object readResolve() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(Objects.equals(singleton1, singleton2));
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}
