package com.shijianwei.main.learn.multithreaded.produceConcumer;

/**
 * @author SHI
 * @date 2022/4/20 16:11
 */
public class Main {


    public static void main(String[] args) {
        Storage storage = new Storage();
        Thread consumer1 = new Thread(new Consumer(storage));
        Thread consumer2 = new Thread(new Consumer(storage));
        Thread consumer3 = new Thread(new Consumer(storage));

        Thread provider1 = new Thread(new Producer(storage));
        Thread provider2 = new Thread(new Producer(storage));
        Thread provider3 = new Thread(new Producer(storage));


        consumer1.start();
        consumer2.start();
        consumer3.start();

        provider1.start();
        provider2.start();
        provider3.start();

    }


    //面试时写的生产者消费者，太简单了，并且并不完善
//    static volatile int storage = 0;
//    public static void main(String[] args) {
////        Storage storage = new Storage();
//        Thread consumer1 = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            while (storage > 0) {
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                storage--;
//                System.out.println("消费者消费了一个商品，此时库存为：" + storage);
//            }
//        });
//
//        Thread producer1 = new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                storage++;
//                System.out.println("生产者生产了一个商品，此时库存为：" + storage);
//            }
//        });
//
//        consumer1.start();
//        producer1.start();
//    }
}
