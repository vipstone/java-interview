package com.interview.chapter1;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description 第一章 第六节 代码示例
 * @Author wanglei
 * @Date 2019/5/2
 **/
public class Section6 {
    public static void main(String[] args) throws ParseException, InterruptedException {
        /********** 获取当前时间的几种方式 **********/
        Date date = new Date(); // 获取当前日期
        System.out.println(date);
        long timestamp = date.getTime(); // 获取当前时间戳（精确到毫秒）
        SimpleDateFormat sf = new SimpleDateFormat("E");
        Calendar calendar = Calendar.getInstance(); // 获取当前日期
        System.out.println(timestamp);
        System.out.println(sf.format(date));
        System.out.println(calendar.getTime());
        /********** 获取当前时间戳的时间戳 **********/
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
        System.out.println(Calendar.getInstance().getTime());
        /********** String 转 Date **********/
        String str = "2019-10-10 10:10:10";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.parse(str));
        /********** 时间戳的字符串 转 Date **********/
        String tsString = "1556788591462";
        // import java.sql
        Timestamp ts = new Timestamp(Long.parseLong(tsString)); // 时间戳的字符串 转 Date
        Date d = ts;
        System.out.println(sf.format(date));
        /********** LocalDateTime 相关时间操作 **********/
        long milli = Instant.now().toEpochMilli(); // 获取当前时间戳（精确到毫秒）
        long second = Instant.now().getEpochSecond(); // 获取当前时间戳（精确到秒）
        System.out.println("当前时间戳（精确到毫秒）:" + milli);
        System.out.println("当前时间戳（精确到秒）:" + second);
        LocalDateTime localDateTime = LocalDateTime.now();
        // LocalDateTime 时间格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(localDateTime));
        /********** 增减时间和计算时间间隔 **********/
        calendar.add(Calendar.DATE, -3); // 获取三天前的时间
        System.out.println(simpleDateFormat.format(calendar.getTime()));
        // 相隔时间（毫秒）计算
        long start = System.currentTimeMillis();
        Thread.sleep(2 * 1000);
        long end = System.currentTimeMillis();
        long diffMillis = end - start; // 结束时间 - 开始时间 = 相隔时间（毫秒）
        System.out.println(diffMillis);
        // 更优雅的当前时间格式化
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        // 增减日期
        System.out.println(LocalDateTime.now().plusDays(-1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        // 获取时间的3种方式
        System.out.println(new Date());
        System.out.println(Calendar.getInstance().getTime());
        System.out.println(LocalDateTime.now());
        Date date1 = new Date();
        Thread.sleep(300);
        Date date2 = new Date();
        System.out.println(date1.compareTo(date2));
    }
}
