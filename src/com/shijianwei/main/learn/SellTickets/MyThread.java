package com.shijianwei.main.learn.SellTickets;

/**
 * @author SHI
 * @date 2022/3/2 21:07
 */
public class MyThread implements Runnable {
    int num;

    public MyThread() {
    }

    public MyThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {


        while (num > 0) {
            synchronized(this) {
                System.out.println(Thread.currentThread().getName() + "：卖了第" + num + "张票！");
                num--;
            }
        }

    }
}
