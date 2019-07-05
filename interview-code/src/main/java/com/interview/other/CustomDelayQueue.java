package com.interview.other;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * 如何使用Java原生方式，手撸一个延迟队列（MQ）？多生产者版本
 **/
public class CustomDelayQueue {
    // 消息编号
    static AtomicInteger MESSAGENO = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();
        // 生产者1
        producer(delayQueue, "生产者1");

        // 生产者2
        producer(delayQueue, "生产者2");

        // 消费者
        consumer(delayQueue);

        /* 执行结果
            生产者1，消息编号：1 发送时间：2019-6-12 20:38:37 延迟：2 秒 |执行时间：2019-6-12 20:38:39
            生产者2，消息编号：2 发送时间：2019-6-12 20:38:37 延迟：2 秒 |执行时间：2019-6-12 20:38:39
            生产者1，消息编号：3 发送时间：2019-6-12 20:38:41 延迟：4 秒 |执行时间：2019-6-12 20:38:45
            生产者1，消息编号：5 发送时间：2019-6-12 20:38:43 延迟：2 秒 |执行时间：2019-6-12 20:38:45
            ....
         */
    }

    //生产者
    private static void producer(DelayQueue<DelayedElement> delayQueue, String name) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // 产生 1~5 秒的随机数
                    long time = 1000L * (new Random().nextInt(5) + 1);
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 组合消息体
                    String message = String.format("%s，消息编号：%s 发送时间：%s 延迟：%s 秒",
                            name, MESSAGENO.getAndIncrement(), DateFormat.getDateTimeInstance().format(new Date()), time / 1000);
                    // 生产消息
                    delayQueue.put(new DelayedElement(message, time));
                }
            }
        }).start();
    }

    //消费者
    private static void consumer(DelayQueue<DelayedElement> delayQueue) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    DelayedElement element = null;
                    try {
                        // 消费消息
                        element = delayQueue.take();
                        System.out.println(element);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    // 延迟队列对象
    static class DelayedElement implements Delayed {
        // 过期时间（单位：毫秒）
        long time = System.currentTimeMillis();
        // 消息体
        String message;
        // 参数：delayTime 延迟时间（单位毫秒）
        public DelayedElement(String message, long delayTime) {
            this.time += delayTime;
            this.message = message;
        }
        @Override
        // 获取过期时间
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
        @Override
        // 队列元素排序
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else
                return 0;
        }
        @Override
        public String toString() {
            // 打印消息
            return message + " |执行时间：" + DateFormat.getDateTimeInstance().format(new Date());
        }
    }
}
