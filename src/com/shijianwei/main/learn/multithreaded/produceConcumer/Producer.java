package com.shijianwei.main.learn.multithreaded.produceConcumer;

/**
 * @author SHI
 * @date 2022/4/20 16:03
 */
public class Producer implements Runnable {

    public Producer(Storage storage) {
        this.storage = storage;
    }

    private Storage storage;

    @Override
    public void run() {
        while (true) {
            try {
                storage.produce();
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
