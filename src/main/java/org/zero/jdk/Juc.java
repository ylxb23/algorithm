package org.zero.jdk;

import java.util.concurrent.*;

public class Juc {
    public static void main(String[] args) throws InterruptedException {
        countDownLatchTest();
        cycleBarrierTest();
    }

    public static void cycleBarrierTest() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("there threads all come.");
            }
        });
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " coming...");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " gone...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }, "Thread-CB-1").start();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " coming...");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " gone...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }, "Thread-CB-2").start();
        System.out.println("cycle barrier test end...");
    }

    public static void countDownLatchTest() throws InterruptedException {
        Exchanger<Integer> exchanger = new Exchanger<>();
        CountDownLatch latch = new CountDownLatch(2);
        int[] a = new int[]{1,2,3,5,7,9};
        int[] b = new int[]{2,4,6,8,10};
        new Thread(() -> {
            for(int i=0; i<a.length; i++) {
                try {
                    Thread.sleep(10);
                    int changed = exchanger.exchange(a[i], 50, TimeUnit.MICROSECONDS);
                    System.out.println("thread-1 exec number: " + a[i] + ", got changed number: " + changed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (TimeoutException e) {
                    throw new RuntimeException(e);
                } finally {
                    latch.countDown();
                }
            }
        }).start();
        new Thread(() -> {
            for(int i=0; i<b.length; i++) {
                try {
                    Thread.sleep(10);
                    int changed = exchanger.exchange(b[i], 50, TimeUnit.MICROSECONDS);
                    System.out.println("thread-2 exec number: " + b[i] + ", got changed number: " + changed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (TimeoutException e) {
                    throw new RuntimeException(e);
                } finally {
                    latch.countDown();
                }
            }
        }).start();
        latch.await();
        System.out.println("count down latch test end...");
    }

}
