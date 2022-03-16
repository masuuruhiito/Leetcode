package com.shijianwei.main.learn.DesignPattern.ProxyPattern.JDK;

import com.shijianwei.main.learn.DesignPattern.ProxyPattern.IPerson;

/**
 * @author SHI
 * @date 2022/2/28 18:11
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        IPerson person = (IPerson) new MeipoJDK().getIntence(new Customer());
        person.findLove();
    }
}
