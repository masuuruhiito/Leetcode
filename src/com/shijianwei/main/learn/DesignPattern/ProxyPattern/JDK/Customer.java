package com.shijianwei.main.learn.DesignPattern.ProxyPattern.JDK;

import com.shijianwei.main.learn.DesignPattern.ProxyPattern.IPerson;

/**
 * @author SHI
 * @date 2022/2/28 17:56
 */
public class Customer implements IPerson {

    @Override
    public void findLove() {
        System.out.println("肤白貌美大长腿");
    }
}
