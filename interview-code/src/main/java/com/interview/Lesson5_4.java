package com.interview;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadLocalTest {
    static Integer MOCK_MAX = 10000;
    static Integer THREAD_MAX = 100;

    public static void main(String[] args) throws InterruptedException {
        // ThreadLocal 使用
        ThreadLocal threadLocal = new ThreadLocal();
        // 存值
        threadLocal.set(Arrays.asList("老王", "Java 面试题"));
        // 取值
        List list = (List) threadLocal.get();
        System.out.println(list.size());
        System.out.println(threadLocal.get());
        //删除值
        threadLocal.remove();
        System.out.println(threadLocal.get());
        // InheritableThreadLocal 使用
        ThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
        inheritableThreadLocal.set("老王");
        new Thread(() -> System.out.println(inheritableThreadLocal.get())).start();
        inheritableThreadLocal.remove();
        // ThreadLocal 模拟内存溢出
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_MAX);
        for (int i = 0; i < THREAD_MAX; i++) {
            executorService.execute(() -> {
                threadLocal.set(new ThreadLocalTest().getList());
                System.out.println(Thread.currentThread().getName());
//                threadLocal.remove();   // 不注释此行内存溢出
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        // InheritableThreadLocal and ThreadLocal 值比较
        ThreadLocal threadLocal1 = new InheritableThreadLocal();
        threadLocal1.set("老王");
        ThreadLocal threadLocal2 = new ThreadLocal();
        threadLocal2.set("老王");
        new Thread(() -> {
            System.out.println(threadLocal1.get().equals(threadLocal2.get()));
        }).start();
    }

    List getList() {
        List list = new ArrayList();
        for (int i = 0; i < MOCK_MAX; i++) {
            list.add("Version：JDK 8");
            list.add("ThreadLocal");
            list.add("Author：老王");
            list.add("DateTime：" + LocalDateTime.now());
            list.add("Test：ThreadLocal OOM");
        }
        return list;
    }
}
