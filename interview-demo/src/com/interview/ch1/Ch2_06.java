package com.interview.ch1;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @Description 第一章 第六节 代码示例
 * @Author wanglei
 * @Date 2019/5/2
 * @Param
 * @return
 **/
public class Ch2_06 {
    public static void main(String[] args) throws ParseException {

        /*
         * 获取当前时间的几种方式
         */
//        Date date = new Date(); // 获取当前日期
//        System.out.println(date);
//        long timestamp = date.getTime(); // 获取当前时间戳（精确到毫秒）
//        SimpleDateFormat sf = new SimpleDateFormat("E");
//        System.out.println(simpleFormatter.format(date));
//        Calendar calendar = Calendar.getInstance(); // 获取当前日期
//        System.out.println(calendar.getTime());

        /*
         * 获取当前时间戳的时间戳
         */
//        System.out.println(System.currentTimeMillis());
//        System.out.println(new Date().getTime());
//        System.out.println(Calendar.getInstance().getTime());

        /*
         * String 转 Date
         */
//        String str = "2019-10-10 10:10:10";
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = sf.parse(str);

        /*
         * 时间戳的字符串 转 Date
         */
//        String tsString = "1556788591462";
//        // import java.sql
//        Timestamp ts = new Timestamp(Long.parseLong(tsString)); // 时间戳的字符串 转 Date
//        Date date = ts;
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sf.format(date));


    }
}
