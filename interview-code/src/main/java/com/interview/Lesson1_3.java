package com.interview;

public class Lesson1_3 {
    public static void main(String[] args) {
        // String 引用对比
        String s1 = "laowang";
        String s2 = s1;
        String s3 = new String(s1);
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        // java编译对String的优化
        String as1 = "hi," + "lao" + "wang";
        String as2 = "hi,";
        as2 += "lao";
        as2 += "wang";
        String as3 = "hi,laowang";
        System.out.println(as1 == as3); // false
        System.out.println(as1 == as3); // true
        System.out.println(as2 == as3); // false
        // String参数传递
        String str = new String("laowang");
        change(str);
        System.out.println(str); // laowang
        // StringBuffer参数传递
        StringBuffer sb = new StringBuffer("hi,");
        changeBuffer(sb);
        System.out.println(sb); // hi,laowang
        // substring截取
        String subStr = "ABCDEF";
        System.out.println(subStr.substring(2)); // CDEF
        System.out.println(subStr.substring(2, 4)); // CD（包含开始下标不包含结束下标）
        // String.format
        String sf = String.format("我叫%s，今年%d岁，喜欢%s", "老王", 30, "读书");
        System.out.println(sf);
        // String equals
        String es1 = "hi," + "lao" + "wang";
        String es2 = "hi,";
        es2 += "lao";
        es2 += "wang";
        String es3 = "hi,laowang";
        System.out.println(es1.equals(es2));
        System.out.println(es1.equals(es3));
        System.out.println(es2.equals(es3));
        // String 大小写比较
        String eis1 = "Hi,laowang";
        String eis2 = "hi,laowang";
        System.out.println(eis1.equals(eis2)); // false
        System.out.println(eis1.equalsIgnoreCase(eis2)); // true
        // StringBuilder 用法
        StringBuilder stringBuilder = new StringBuilder("lao");
        // 添加字符串到尾部
        stringBuilder.append("wang"); // laowang
        // 插入字符串到到当前字符串下标的位置
        stringBuilder.insert(0, "hi,"); // hi,laowang
        // 修改字符中某个下标的值
        stringBuilder.setCharAt(0, 'H'); // Hi,laowang
        System.out.println(stringBuilder);
        // String intern 用法
        String str1 = "hi";
        String str2 = new String("hi");
        String str3 = new String("hi").intern();
        System.out.println(str1 == str2); // false
        System.out.println(str1 == str3); // true
    }

    public static void change(String s) {
        s = "xiaowang";
    }

    public static void changeBuffer(StringBuffer sb) {
        sb.append("laowang");
    }
}
