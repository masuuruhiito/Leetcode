package com.shijianwei.main.learn.DesignPattern.ProxyPattern.CGLib;

import com.shijianwei.main.learn.DesignPattern.ProxyPattern.APerson;

/**
 * @author SHI
 * @date 2022/2/28 17:56
 */
public class Customer extends APerson {

    @Override
    public void findLove() {
        System.out.println("肤白貌美大长腿");
    }

    @Override
    public void drink() {
        System.out.println("drink");
    }
}
