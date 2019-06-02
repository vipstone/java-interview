package com.interview.chapter3;

import java.util.*;

class Section1 {
    public static void main(String[] args) {
        // -------------------------- Vector 使用代码 ----------------------------
        Vector vector = new Vector();
        vector.add("dog");
        vector.add("cat");
        vector.remove("cat");
        System.out.println(vector);

        // -------------------------- ArrayList 使用代码 ----------------------------
        ArrayList arrayList = new ArrayList();
        arrayList.add("dog");
        arrayList.add("cat");
        arrayList.remove("cat");
        System.out.println(arrayList);

        // -------------------------- LinkedList 使用代码 ----------------------------
        LinkedList linkedList = new LinkedList();
        // 添加元素
        linkedList.offer("bird");
        linkedList.push("cat");
        linkedList.push("dog");
        // 获取第一个元素
        System.out.println(linkedList.peek());
        // 获取第一个元素，并删除此元素
        System.out.println(linkedList.poll());
        System.out.println(linkedList);

        // -------------------------- HashSet 使用代码 ----------------------------
        HashSet hashSet = new HashSet();
        hashSet.add("dog");
        hashSet.add("camel");
        hashSet.add("cat");
        System.out.println(hashSet);

        // -------------------------- TreeSet 使用代码 ----------------------------
        TreeSet treeSet = new TreeSet();
        treeSet.add("dog");
        treeSet.add("camel");
        treeSet.add("cat");
        treeSet.add("ant");
        System.out.println(treeSet);

        // -------------------------- LinkedHashSet 使用代码 ----------------------------
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("dog");
        linkedHashSet.add("camel");
        linkedHashSet.add("cat");
        linkedHashSet.add("ant");
        System.out.println(linkedHashSet);

        // -------------------------- 集合与数组的互相转换 ----------------------------
        List<String> list = new ArrayList();
        list.add("cat");
        list.add("dog");
        // 集合转数组
        String[] arr = list.toArray(new String[list.size()]);
        // 数组转集合
        List<String> list2 = Arrays.asList(arr);
        System.out.println(list2);

        // -------------------------- Stack 后进先出演示代码 ----------------------------
        Stack stack = new Stack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        for (int i = 0; i < 3; i++) {
            // 移除并返回栈顶元素
            System.out.println(stack.pop());
        }

        // -------------------------- 集合排序（Comparable/Comparator） ----------------------------
        Dog[] dogs = new Dog[]{
                new Dog("老旺财", 10),
                new Dog("小旺财", 3),
                new Dog("二旺财", 5),
        };
        // Comparable 排序
        Arrays.sort(dogs);
        // Comparator 排序
        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        for (Dog d : dogs) {
            System.out.println(d.getName() + "：" + d.getAge());
        }
    }
}

class Dog implements Comparable<Dog> {
    private String name;
    private int age;

    @Override
    public int compareTo(Dog o) {
        return age - o.age;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
