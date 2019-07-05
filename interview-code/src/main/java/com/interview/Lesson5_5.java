package com.interview;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Lesson5_5 {
    static int number = 0;

    public static void main(String[] args) throws InterruptedException {
        // ReentrantLock 使用
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread1 = new Thread(() -> {
            try {
                reentrantLock.lock();
                addNumber();
            } finally {
                reentrantLock.unlock();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                reentrantLock.lock();
                addNumber();
            } finally {
                reentrantLock.unlock();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("number：" + number);
        // synchronized 使用
        Object syn = new Object();
        Thread sThread = new Thread(() -> {
            synchronized (syn) {
                addNumber();
            }
        });
        Thread sThread2 = new Thread(() -> {
            synchronized (syn) {
                addNumber();
            }
        });
        sThread.start();
        sThread2.start();
        sThread.join();
        sThread2.join();
        System.out.println("number：" + number);

    }

    public static void addNumber() {
        for (int i = 0; i < 10000; i++) {
            ++number;
        }
    }
}

/**
 * @Description 非线程安全代码演示
 **/
class ThreadSafeTest {
    static int number = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> addNumber());
        Thread thread2 = new Thread(() -> addNumber());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("number：" + number);
    }

    public static void addNumber() {
        for (int i = 0; i < 10000; i++) {
            ++number;
        }
    }
}

