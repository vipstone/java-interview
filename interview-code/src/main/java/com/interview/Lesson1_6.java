package com.interview;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class Lesson1_6 {
    public static void main(String[] args) throws ParseException, InterruptedException {
        // 时间操作 JDK 8 以前
        // 获得当前时间
        Date date = new Date();
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        System.out.println(time);
        // 获取当前时间戳
        long ts1 = new Date().getTime();
        System.out.println(ts1);
        long ts2 = System.currentTimeMillis();
        System.out.println(ts2);
        long ts3 = Calendar.getInstance().getTimeInMillis();
        System.out.println(ts3);
        // 时间格式化
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(new Date()));  // output:2019-08-16 21:46:22
        // String 转 Date
        String str = "2019-10-10 10:10:10";
        System.out.println(sf.parse(str));
        //时间戳的字符串 转 Date
        String tsString = "1556788591462";
        // import java.sql
        Timestamp ts = new Timestamp(Long.parseLong(tsString)); // 时间戳的字符串 转 Date
        System.out.println(sf.format(ts));
        // 获得昨天此刻的时间
        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTime());
        // JDK 8 时间操作
        // 相隔时间
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = dt1.plusSeconds(60);
        Duration duration = Duration.between(dt1, dt2);
        System.out.println(duration.getSeconds());  // output:60
        // 相隔日期
        LocalDate d1 = LocalDate.now();
        LocalDate d2 = d1.plusDays(2);
        Period period = Period.between(d1, d2);
        System.out.println(period.getDays());   //output:2
        // 获取日期
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        // 获取时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        // 获取日期和时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        // 获取时间戳
        long milli = Instant.now().toEpochMilli(); // 获取当前时间戳（精确到毫秒）
        long second = Instant.now().getEpochSecond(); // 获取当前时间戳（精确到秒）
        System.out.println(milli);  // output:1565932435792
        System.out.println(second); // output:1565932435
        // 格式化时间①
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeFormat = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(timeFormat);  // output:2019-08-16 21:15:43
        // 格式化时间②
        String timeFormat2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(timeFormat2);    // output:2019-08-16 21:17:48
        // 获取昨天此刻时间
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.plusDays(-1);
        System.out.println(yesterday);
        // 获取本月的最后一天（JDK 8 之前）
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(ca.getTime());
        // 获取本月的最后一天（JDK 8）
        System.out.println(today.with(TemporalAdjusters.lastDayOfMonth()));
    }
}
