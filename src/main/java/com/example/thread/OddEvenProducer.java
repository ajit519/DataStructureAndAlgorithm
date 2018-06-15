package com.example.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenProducer {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition  condition = lock.newCondition();
        Thread evenThread = new Thread(new EvenWorker(lock, condition));
        Thread oddThread = new Thread(new OddWorker(lock, condition));
        evenThread.start();
        oddThread.start();

    }
}
