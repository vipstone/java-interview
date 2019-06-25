package com.interview.chapter5;

import javafx.scene.input.DataFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;

class ThreadTest {
    public static void main(String[] args) throws Exception {
        // 创建方式一：继承 Thread 类
        MyThread thread = new MyThread();
        thread.start();
        // 创建方式二：实现 Runnable 接口
        MyRunnable runnable = new MyRunnable();
        runnable.run();
        // 创建方式三：实现 Callable 接口
        MyCallable callable  = new MyCallable();
        Object result = callable.call();
        System.out.println(result);
        // JDK 8 lambda Thread
        new Thread(() -> System.out.println("Lambda Of Thread.")).start();
        // 设置线程优先级
        Thread priorityThread = new Thread(() -> System.out.println("Java"));
        priorityThread.setPriority(10);
        priorityThread.start();
        //线程休眠
        System.out.println(LocalDateTime.now());
        Object lock = new Object();
        Thread lockThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    // 1 秒钟之后自动唤醒
                    lock.wait(1000);
                    System.out.println(LocalDateTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        lockThread.start();
        // 休眠 1 秒
        Thread.sleep(1000);
        // join 使用
        Thread joinThread = new Thread(() -> {
            try {
                System.out.println("执行前");
                Thread.sleep(1000);
                System.out.println("执行后");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        joinThread.start();
        joinThread.join();
        System.out.println("主程序");
        // yield 使用
        new Thread(){
            @Override
            public void run() {
                for (int i = 1; i < 10; i++) {
                    if (i == 5) {
                        // 让同优先级的线程有执行的机会，但不能保证自己会从正在运行的状态迅速转换到可运行的状态
                        this.yield();
                    }
                }
            }
        }.start();
        // interrupt 使用
        Thread interruptThread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    System.out.println("i：" + i);
                    if (this.isInterrupted()) {
                        break;
                    }
                }
            }
        };
        interruptThread.start();
        Thread.sleep(10);
        interruptThread.interrupt();
        // 死锁演示
        Object obj1 = new Object();
        Object obj2 = new Object();
        // 线程1拥有对象1，想要等待获取对象2
        new Thread() {
            @Override
            public void run() {
                synchronized (obj1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2) {
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            }
        }.start();
        // 线程2拥有对象2，想要等待获取对象1
        new Thread() {
            @Override
            public void run() {
                synchronized (obj2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj1) {
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            }
        }.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable");
    }
}

class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("Callable");
        return "Success";
    }
}


