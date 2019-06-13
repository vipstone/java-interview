package com.interview.chapter3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Section4 {

    public static void main(String[] args) throws InterruptedException {
        // --------------------- LinkedList 使用 ---------------------
        Queue<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Camel");
        linkedList.add("Cat");
        while (!linkedList.isEmpty()) {
            System.out.println(linkedList.poll());
        }

        // --------------------- PriorityQueue 使用 ---------------------
        Queue<Integer> priorityQueue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 非自然排序，数字倒序
                return o2 - o1;
            }
        });
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(2);
        while (!priorityQueue.isEmpty()) {
            Integer i = priorityQueue.poll();
            System.out.println(i);
        }

        // --------------------- DelayQueue 延迟队列 ---------------------
        DelayQueue delayQueue = new DelayQueue();
        delayQueue.put(new DelayElement(1000));
        delayQueue.put(new DelayElement(3000));
        delayQueue.put(new DelayElement(5000));
        System.out.println("开始时间：" +  DateFormat.getDateTimeInstance().format(new Date()));
        while (!delayQueue.isEmpty()){
            System.out.println(delayQueue.take());
        }
        System.out.println("结束时间：" +  DateFormat.getDateTimeInstance().format(new Date()));
    }

    static class DelayElement implements Delayed {
        // 延迟截止时间（单面：毫秒）
        long delayTime = System.currentTimeMillis();

        public DelayElement(long delayTime) {
            this.delayTime = (this.delayTime + delayTime);
        }

        @Override
        // 获取剩余时间
        public long getDelay(TimeUnit unit) {
            return unit.convert(delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        // 队列里元素的排序依据
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return DateFormat.getDateTimeInstance().format(new Date(delayTime));
        }
    }

}


