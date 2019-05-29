package com.interview.chapter2;

import java.io.*;
import java.util.Arrays;

class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 等号赋值（ 基本类型）
        int number = 6;
        int number2 = number;
        // 修改 number2 的值
        number2 = 9;
        System.out.println("number：" + number);
        System.out.println("number2：" + number2);
        Dog dog = new Dog();
        dog.name = "旺财";
        dog.age = 5;
        Dog dog2 = dog;
        // 修改 dog2 的值
        dog2.name = "大黄";
        dog2.age = 3;
        System.out.println(dog.name + "，" + dog.age + "岁");
        System.out.println(dog2.name + "，" + dog2.age + "岁");
        // -------------------------- 克隆 ----------------------------
        Dog dog3 = (Dog) dog.clone();
        dog3.name = "小白";
        dog3.age = 2;
        System.out.println(dog.name + "，" + dog.age + "岁");
        System.out.println(dog3.name + "，" + dog3.age + "岁");
        // -------------------------- 浅克隆 ----------------------------
        DogChild dogChild = new DogChild();
        dogChild.name = "二狗";
        Dog dog4 = new Dog();
        dog4.name = "大黄";
        dog4.dogChild = dogChild;
        Dog dog5 = (Dog) dog4.clone();
        dog5.name = "旺财";
        dog5.dogChild.name = "狗二";
        System.out.println("dog name 4：" + dog4.name);
        System.out.println("dog name 5：" + dog5.name);
        System.out.println("dog child name 4：" + dog4.dogChild.name);
        System.out.println("dog child name 5：" + dog5.dogChild.name);
        // -------------------------- 深克隆（序列化） ----------------------------
        BirdChild birdChild = new BirdChild();
        birdChild.name = "小小鸟";
        Bird bird = new Bird();
        bird.name = "小鸟";
        bird.birdChild = birdChild;
        Bird bird2 = CloneUtils.clone(bird);
        bird2.name = "黄雀";
        bird2.birdChild.name = "小黄雀";
        System.out.println("bird name:" + bird.name);
        System.out.println("bird child name:" + bird.birdChild.name);
        System.out.println("bird name 2:" + bird2.name);
        System.out.println("bird child name 2:" + bird2.birdChild.name);
        /* 输出：
            bird name:小鸟
            bird child name:小小鸟
            bird name 2:黄雀
            bird child name 2:小黄雀
         */
        // --------------------------深克隆（引用类型实现克隆）----------------------------
        ParrotChild parrotChild = new ParrotChild();
        parrotChild.name = "小鹦鹉";
        Parrot parrot = new Parrot();
        parrot.name = "大鹦鹉";
        parrot.parrotChild = parrotChild;
        // 克隆
        Parrot parrot2 = (Parrot) parrot.clone();
        parrot2.name = "老鹦鹉";
        parrot2.parrotChild.name = "少鹦鹉";
        System.out.println("parrot name:" + parrot.name);
        System.out.println("parrot child name:" + parrot.parrotChild.name);
        System.out.println("parrot name 2:" + parrot2.name);
        System.out.println("parrot child name 2:" + parrot2.parrotChild.name);
        /* 输出：
            parrot name:大鹦鹉
            parrot child name:小鹦鹉
            parrot name 2:老鹦鹉
            parrot child name 2:少鹦鹉
         */

        // -------------------------- 面试题 ----------------------------
        CloneObj cloneObj = new CloneObj();
        cloneObj.name = "老王";
        cloneObj.age = 30;
        cloneObj.sistersAge = new int[]{18, 19};
        CloneObj cloneObj2 = (CloneObj) cloneObj.clone();
        cloneObj2.name = "磊哥";
        cloneObj2.age = 33;
        cloneObj2.sistersAge[0] = 20;
        System.out.println(cloneObj.name + "|" + cloneObj2.name);
        System.out.println(cloneObj.age + "|" + cloneObj2.age);
        System.out.println(Arrays.toString(cloneObj.sistersAge) + "|" + Arrays.toString(cloneObj2.sistersAge));
    }
}

// 序列化和反序列化
class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 对象赋值
        User user = new User();
        user.setName("老王");
        user.setAge(30);
        System.out.println(user);

        // 创建输出流（序列化内容到磁盘）
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.out"));
        // 序列化对象
        oos.writeObject(user);
        oos.flush();
        oos.close();

        // 创建输入流（从磁盘反序列化）
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.out"));
        // 反序列化
        User user2 = (User) ois.readObject();
        ois.close();
        System.out.println(user2);
    }
}

class Dog implements Cloneable {
    public String name;
    public int age;
    public DogChild dogChild;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class DogChild {
    public String name;
}

class Bird implements Serializable {
    private static final long serialVersionUID = -8548202819636883145L;
    public String name;
    public BirdChild birdChild;
}

class BirdChild implements Serializable {
    private static final long serialVersionUID = -2767034691908202986L;
    public String name;
}

class Parrot implements Cloneable {
    public String name;
    public ParrotChild parrotChild;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Parrot bird = (Parrot) super.clone();
        bird.parrotChild = (ParrotChild) parrotChild.clone();
        return bird;
    }
}

class ParrotChild implements Cloneable {
    public String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

/**
 * 克隆工具类（通过序列化方式实现深拷贝）
 * 先将要拷贝对象写入到内存中的字节流中，然后再从这个字节流中读出刚刚存储的信息，作为一个新对象返回，那么这个新对象和原对象就不存在任何地址上的共享，自然实现了深拷贝。
 **/
class CloneUtils {
    public static <T extends Serializable> T clone(T obj) {
        T cloneObj = null;
        try {
            //写入字节流
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bo);
            oos.writeObject(obj);
            oos.close();

            //分配内存,写入原始对象,生成新对象
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());//获取上面的输出字节流
            ObjectInputStream oi = new ObjectInputStream(bi);

            //返回生成的新对象
            cloneObj = (T) oi.readObject();
            oi.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }
}

class CloneObj implements Cloneable {
    public String name;
    public int age;
    public int[] sistersAge;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class User implements Serializable {
    private static final long serialVersionUID = 5132320539584511249L;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "{name:" + name + ",age:" + age + "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}