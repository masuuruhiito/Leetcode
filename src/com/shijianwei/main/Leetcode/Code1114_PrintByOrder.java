package com.shijianwei.main.Leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author SHI
 * @date 2022/2/13 11:00
 */
public class Code1114_PrintByOrder {
    public Code1114_PrintByOrder() {

    }
    volatile int i  = 1 ;
    AtomicInteger index = new AtomicInteger(0);
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        index.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        while (index.get()!=1);
        printSecond.run();
        index.incrementAndGet();

    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        while (index.get()!=2);
        printThird.run();
        index.set(1);
    }
}
