package com.shijianwei.main.learn.DesignPattern.SingletonPattern;

/**
 * @author SHI
 * @date 2022/2/28 15:50
 */
public class Hungry {
    private Hungry(){}
    private static final Hungry hungry= new Hungry();
    public static Hungry getInstance(){
        return hungry;
    }
}
