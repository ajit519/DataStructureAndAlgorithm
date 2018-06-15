package com.example.thread.wait;

public class OddWorker implements Runnable {

    private Object lock;

    public OddWorker(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            synchronized (lock) {
                try {
                    if (i % 2 == 0) {
                        lock.notify();
                        lock.wait();
                    } else {
                        System.out.println("Odd " + i);
                    }
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
