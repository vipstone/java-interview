package com.interview;

import java.util.*;

public class Lesson3_2 {
    public static void main(String[] args) {

        Map hashMap = new HashMap();
        // 增加元素
        hashMap.put("name", "老王");
        hashMap.put(null, null);
        hashMap.put("age", "30");
        hashMap.put("sex", "你猜");
        // 删除元素
        hashMap.remove(null);
        // 查找单个元素
        System.out.println(hashMap.get("age"));
        // 循环所有的 key
        for (Object k : hashMap.keySet()) {
            System.out.println(k);
        }
        // 循环所有的值
        for (Object v : hashMap.values()) {
            System.out.println(v);
        }

        // -------------------------- TreeMap 自定义排序 ----------------------------
        TreeMap<String, String> treeMap = new TreeMap(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1); // 倒序
            }
        });
        treeMap.put("dog", "dog");
        treeMap.put("camel", "camel");
        treeMap.put("cat", "cat");
        treeMap.put("ant", "ant");
        // -------------------------- TreeMap 根据 value 倒序 ----------------------------
        // map.entrySet() 转成 List
        List<Map.Entry<String, String>> list = new ArrayList<>(treeMap.entrySet());
        // 通过比较器实现比较排序
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> m1, Map.Entry<String, String> m2) {
                return m2.getValue().compareTo(m1.getValue());
            }
        });
        for (Map.Entry<String, String> item : list) {
            System.out.println(item.getKey() + ":" + item.getValue());
        }

        // -------------------------- LinkedHashMap 使用 ----------------------------
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dog", "dog");
        linkedHashMap.put("camel", "camel");
        linkedHashMap.put("cat", "cat");
        linkedHashMap.put("ant", "ant");
        System.out.println(linkedHashMap);

        // -------------------------- hashCode 和 equals 测试 ----------------------------
        HashMap<Person, Integer> map = new HashMap<>();
        Person person = new Person(18);
        map.put(person, 1);
        System.out.println(map.get(new Person(18)));
    }
}

class Person {
    private Integer age;

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Person)) {
            return false;
        } else {
            return this.getAge().equals(((Person) o).getAge());
        }
    }

    //    public int hashCode() {
//        return age.hashCode();
//    }
    public Person(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public static void main(String[] args) {
//        HashMap<Person, Integer> hashMap = new HashMap<>();
        Person p1 = new Person(18);
        Person p2 = new Person(18);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode() + " : " + p2.hashCode());
//        hashMap.put(person, 1);
//        System.out.println(hashMap.get(new Person(18)));
    }
}
