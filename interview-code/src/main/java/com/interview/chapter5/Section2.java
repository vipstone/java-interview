package com.interview.chapter5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Section2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10,
                10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        // execute 使用
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, Java.");
            }
        });
        // submit 使用
        Future<String> future = threadPoolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Hello, 老王.");
                return "Success";
            }
        });
        System.out.println(future.get());
        // shutdown 使用
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 2; i++) {
                System.out.println("I'm " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        threadPoolExecutor.shutdown();
        threadPoolExecutor.execute(() -> {
            System.out.println("I'm Java.");
        });
        // newFixedThreadPool 使用
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            fixedThreadPool.execute(() -> {
                System.out.println("CurrentTime - " +
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        // newCachedThreadPool 使用
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            cachedThreadPool.execute(() -> {
                System.out.println("CurrentTime - " +
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        //  newSingleThreadExecutor 使用
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            singleThreadExecutor.execute(() -> {
                System.out.println("CurrentTime - " +
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        // newScheduledThreadPool 使用
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
        scheduledThreadPool.schedule(() -> {
            System.out.println("ThreadPool：" + LocalDateTime.now());
        }, 1L, TimeUnit.SECONDS);
        System.out.println("CurrentTime：" + LocalDateTime.now());
        // newSingleThreadScheduledExecutor 使用
        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        singleThreadScheduledExecutor.schedule(() -> {
            System.out.println("ThreadPool：" + LocalDateTime.now());
        }, 1L, TimeUnit.SECONDS);
        System.out.println("CurrentTime：" + LocalDateTime.now());
        // newWorkStealingPool 使用
        ExecutorService workStealingPool = Executors.newWorkStealingPool();
        for (int i = 0; i < 10; i++) {
            int finalNumber = i;
            workStealingPool.execute(() -> {
                    System.out.println(finalNumber);
            });
        }
        Thread.sleep(5000);
    }
}
