package com.interview;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class Lesson5_6 {
    public static void main(String[] args) throws InterruptedException {
        // CountDownLatch 使用
        CountDownLatch hospitalLatch = new CountDownLatch(1);   // 医院闭锁
        CountDownLatch patientLatch = new CountDownLatch(5);    // 患者闭锁
        System.out.println("患者排队");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            executorService.execute(() -> {
                try {
                    hospitalLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("体检：" + j);
                patientLatch.countDown();
            });
        }
        System.out.println("医生上班");
        hospitalLatch.countDown();
        patientLatch.await();
        System.out.println("医生下班");
        executorService.shutdown();
        // CyclicBarrier 使用
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("发车了");
            }
        });
        for (int i = 0; i < 4; i++) {
            new Thread(new CyclicWorker(cyclicBarrier)).start();
        }
        // Semaphore 使用
        Semaphore semaphore = new Semaphore(2);
        ThreadPoolExecutor semaphoreThread = new ThreadPoolExecutor(10, 50,
                60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 7; i++) {
            semaphoreThread.execute(() -> {
                try {
                    // 堵塞获取许可
                    semaphore.acquire();
                    System.out.println("Thread：" + Thread.currentThread().getName() + " 时间：" + LocalDateTime.now());
                    TimeUnit.SECONDS.sleep(2);
                    // 释放许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


    }

    static class CyclicWorker implements Runnable {
        private CyclicBarrier cyclicBarrier;

        CyclicWorker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                System.out.println("乘客：" + i);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
