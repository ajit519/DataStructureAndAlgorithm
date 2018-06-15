package com.example.thread.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotifySolution {

    public static void main(String[] args) {
        Object lock = new Object();
        EvenWorker evenWorker = new EvenWorker(lock);
        OddWorker oddWorker = new OddWorker(lock);
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(evenWorker);
        service.submit(oddWorker);
    }
}
