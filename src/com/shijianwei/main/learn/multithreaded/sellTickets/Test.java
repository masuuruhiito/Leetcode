package com.shijianwei.main.learn.multithreaded.sellTickets;

/**
 * @author SHI
 * @date 2022/3/2 21:09
 */
public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread(1000) ;

        new Thread(myThread , "售票口1：").start();
        new Thread(myThread , "售票口2：").start();
    }
}
