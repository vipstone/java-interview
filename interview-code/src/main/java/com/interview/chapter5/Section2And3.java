package com.interview.chapter5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Section2And3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10,
                10L, TimeUnit.SECONDS, new LinkedBlockingQueue(100));
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
        // ThreadPoolExecutor 七个参数的使用示例
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1,
                10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(2),
                new MyThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        threadPool.allowCoreThreadTimeOut(true);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}

class MyThreadFactory implements ThreadFactory {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        String threadName = "MyThread" + count.addAndGet(1);
        t.setName(threadName);
        return t;
    }
}

class MyRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // 记录异常、报警处理等
        System.out.println("Error Message.");
    }
}
