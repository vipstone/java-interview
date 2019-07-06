package com.interview;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lesson5_5 {
    static int number = 0;

    public static void main(String[] args) throws InterruptedException {
        // ReentrantLock 基本使用
        Lock lock = new ReentrantLock();
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                addNumber();
            } finally {
                lock.unlock();
            }
        });
        Thread thread2 = new Thread(() -> {
            lock.lock();
            try {
                addNumber();
            } finally {
                lock.unlock();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("number：" + number);
        // ReentrantLock tryLock
        Lock reentrantLock = new ReentrantLock();
        // 线程一
        new Thread(() -> {
            try {
                reentrantLock.lock();
                System.out.println(LocalDateTime.now());
                Thread.sleep(2 * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }).start();
        // 线程二
        new Thread(() -> {
            try {
                Thread.sleep(1 * 1000);
//                System.out.println(reentrantLock.tryLock());
//                Thread.sleep(2 * 1000);
//                System.out.println(reentrantLock.tryLock());
                System.out.println(reentrantLock.tryLock(3, TimeUnit.SECONDS));
                System.out.println(LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
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
        // ReentrantLock lockInterruptibly() vs lock()
        Lock interruptLock = new ReentrantLock();
        interruptLock.lock();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    interruptLock.lock();
//                    interruptLock.lockInterruptibly();  // java.lang.InterruptedException
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Over");
        System.exit(0);
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

