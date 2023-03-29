package org.zero.jdk;

import java.util.concurrent.locks.ReentrantLock;

public class Lock {

    public static void main(String[] args) {
        Lock lock = new Lock();
        lock.lockPrint();
    }

    public void lockPrint() {
        synchronized (this) {
            System.out.println("This is lock print.");
            synchronized (this) {
                System.out.println("This is lock print inner.");
            }
        }
    }

    public void printNormal() {
        System.out.println("This is normal print.");
    }

    public static void print() {
        synchronized (Lock.class) {
            System.out.println("This is static method lock print.");
        }
    }

    public static void testReentrantLock() {
        ReentrantLock lock = new ReentrantLock();
    }
}
