package com.interview;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Lesson1_1 {
    public static void main(String[] args) {
        // 获取明天此刻时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        System.out.println(calendar.getTime());
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow = today.minusDays(-1);
        //LocalDateTime tomorrow = today.plusDays(1);
        System.out.println(tomorrow);
    }
}
