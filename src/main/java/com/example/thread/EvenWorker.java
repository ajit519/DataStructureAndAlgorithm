package com.example.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class EvenWorker implements Runnable {

    private Lock lock;
    private Condition condition;

    public EvenWorker(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            try {
                lock.lock();
                if (i % 2 != 0) {
                    condition.signal();
                    condition.await();
                } else {
                    System.out.println("Even :: " + i);
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            } finally {
                lock.unlock();
            }

        }
    }
}
