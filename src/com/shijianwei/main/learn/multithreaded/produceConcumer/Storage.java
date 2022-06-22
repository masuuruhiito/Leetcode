package com.shijianwei.main.learn.multithreaded.produceConcumer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SHI
 * @date 2022/4/20 16:13
 */
public class Storage {

    private final static int Max_Size = 10;

    private static final List<Object> list = new LinkedList<>();

    public void produce() throws InterruptedException {
        synchronized (list) {
            while (list.size() + 1 > Max_Size) {
                System.out.println("生产者" + Thread.currentThread().getName() + "仓库已满！");
                list.wait();
            }
            list.add(new Object());
            System.out.println("生产者" + Thread.currentThread().getName() + "生产了一个产品，此时库存为：" + list.size());
            list.notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (list) {
            while (list.size() == 0) {
                System.out.println("消费者" + Thread.currentThread().getName() + "仓库为空");
                list.wait();
            }
            list.remove(0);
            System.out.println("消费者" + Thread.currentThread().getName() + "消费了一个产品，此时库存为：" + list.size());
            list.notifyAll();
        }
    }
}
