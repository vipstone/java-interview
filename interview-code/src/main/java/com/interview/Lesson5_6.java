package com.interview;

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
