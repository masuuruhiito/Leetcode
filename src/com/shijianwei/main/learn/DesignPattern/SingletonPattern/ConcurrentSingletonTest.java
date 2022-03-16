package com.shijianwei.main.learn.DesignPattern.SingletonPattern;

/**
 * @author SHI
 * @date 2022/2/28 16:15
 */
public class ConcurrentSingletonTest {
    static class MyThread implements Runnable{
        @Override
        public void run() {
            Lazy lazy = Lazy.getInstance();
            System.out.println(Thread.currentThread().getName()+lazy);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread());
        Thread thread2 = new Thread(new MyThread());
        thread1.start();
        thread2.start();
    }
}
