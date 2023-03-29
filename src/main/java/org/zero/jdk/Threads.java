package org.zero.jdk;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        latch.countDown();
        latch.countDown();
        latch.await();
        System.out.println("over...");
        CyclicBarrier cb = new CyclicBarrier(2);
        int cbW = cb.getNumberWaiting();
        System.out.println("cb number waiting: " + cbW);

    }
}
