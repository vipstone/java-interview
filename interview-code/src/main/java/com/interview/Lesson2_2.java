package com.interview;

/*********** 1、成员内部类（可以使用任意修饰符） **********/
class InnerTest {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.sayHi();
    }
}

class Outer {
    private String name = "OuterClass";
    int age = 18;

    public void sayHi() {
        System.out.println(new Inner().name);
        System.out.println("Hi, Outer.");
    }

    class Inner {
        String name = "InnerClass";

        public void sayHi() {
            // 内部类访问外部类
            Outer.this.sayHi();
            System.out.println(Outer.this.name);
            System.out.println("Hi, Inner.");
        }
    }
}

/*********** 2、静态内部类（可以使用任意修饰符） **********/
class OuterClass {
    String name = "OuterClass";

    public OuterClass() {
        System.out.println("OuterClass Init.");
    }

    protected static class InnerClass {
        String name = "InnerClass";

        public void sayHi() {
            System.out.println("Hi, InnerClass.");
        }
    }
}

class InnerClassTest {
    public static void main(String[] args) {
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
        innerClass.sayHi();
    }
}

/*********** 3、局部内部类 **********/
class OutClass3 {
    int age = 18;

    public void sayHi() {
        class InnerClass3 {
            InnerClass3(String name) {
                System.out.println(age);
                System.out.println("InnerClass:" + name);
            }
        }
        System.out.println(new InnerClass3("Three"));
        System.out.println("Hi, OutClass");
    }
}

class OutTest3 {
    public static void main(String[] args) {
        new OutClass3().sayHi();
    }
}

/*********** 4、匿名内部类 **********/
interface AnonymityOuter {
    void hi();
}

class AnonymityTest {
    public static void main(String[] args) {
        AnonymityOuter anonymityOuter = new AnonymityOuter() {
            @Override
            public void hi() {
                System.out.println("Hi, AnonymityOuter.");
            }
        };
        anonymityOuter.hi();
    }
}

/*********** 枚举使用 **********/
class EnumTest {
    public static void main(String[] args) {
        ColorEnum color = ColorEnum.GREEN;
        switch (color) {
            case RED:
                System.out.println("Red");
                break;
            case BLUE:
                System.out.println("Blue");
                break;
            case YELLOW:
                System.out.println("Yellow");
                break;
            case GREEN:
                System.out.println("Green");
                break;
            default:
                break;
        }
        /*********** 枚举比较 **********/
        ColorEnum redColor = ColorEnum.RED;
        ColorEnum redColor2 = ColorEnum.RED;
        System.out.println(redColor == redColor2);
        System.out.println(redColor.equals(redColor2));
        /*********** 枚举扩展方法 **********/
        System.out.println(ColorsEnum.RED.getName());
        System.out.println(ColorsEnum.RED.getIndex());
    }
}

/*********** 无参数枚举类 **********/
enum ColorEnum {
    RED,
    BLUE,
    YELLOW,
    GREEN
}

/*********** 自定义参数的枚举类 **********/
enum ColorsEnum {
    RED("红色", 1),
    BLUE("蓝色", 2),
    YELLOW("黄色", 3),
    GREEN("绿色", 4);

    ColorsEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    private String name;
    private int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}



