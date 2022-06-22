package com.shijianwei.main.learn.multithreaded.produceConcumer;

/**
 * @author SHI
 * @date 2022/4/20 16:08
 */
public class Consumer implements Runnable {
    public Consumer(Storage storage) {
        this.storage = storage;
    }

    Storage storage;

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                try {
                    storage.consume();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
