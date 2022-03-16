package com.shijianwei.main.learn.DesignPattern.SingletonPattern;

/**
 * @author SHI
 * @date 2022/2/28 15:59
 */
public class SingletonTest {
    public static void main(String[] args) {
        System.out.println(Hungry.getInstance());
        System.out.println(Hungry.getInstance());
        System.out.println(Hungry.getInstance());
        System.out.println(Hungry.getInstance());
        System.out.println(Hungry.getInstance());
        System.out.println(Hungry.getInstance());


        System.out.println(Lazy.getInstance());
        System.out.println(Lazy.getInstance());
        System.out.println(Lazy.getInstance());
        System.out.println(Lazy.getInstance());
        System.out.println(Lazy.getInstance());
    }
}
