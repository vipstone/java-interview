package com.interview.chapter3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Section3 {
    public static void main(String[] args) {

        Map<String, String> hashMap = new HashMap();
        hashMap.put("name", "老王");
        hashMap.put("sex", "你猜");
        // 方式一：entrySet 遍历
        for (Map.Entry item : hashMap.entrySet()) {
            System.out.println(item.getKey() + ":" + item.getValue());
        }
        // 方式二：iterator 遍历
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        // 方式三：遍历所有的 key 和 value
        for (Object k : hashMap.keySet()) {
            // 循环所有的 key
            System.out.println(k);
        }
        for (Object v : hashMap.values()) {
            // 循环所有的值
            System.out.println(v);
        }
        // 方式四：通过 key 值遍历
        for (Object k : hashMap.keySet()) {
            System.out.println(k + ":" + hashMap.get(k));
        }


    }
}
