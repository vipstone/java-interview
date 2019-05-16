package com.interview.chapter2;


/*********** 1、成员内部类（可以使用任意修饰符） **********/
class InnerTest {
    public static void main(String[] args) {
        Outter out = new Outter();
        Outter.Inner inner = out.new Inner();
        inner.sayHi();
    }
}

class Outter {
    public Outter() {
        System.out.println("Outter Class.");
    }

    class Inner {
        public void sayHi() {
            System.out.println("Hi, Inner.");
        }
    }
}

/*********** 2、静态内部类（可以使用任意修饰符） **********/
class OutterClass {
    public OutterClass() {
        System.out.println("OutterClass Init.");
    }

    protected static class InnerClass {
        public void sayHi() {
            System.out.println("Hi, InnerClass.");
        }
    }
}

class InnerClassTest {
    public static void main(String[] args) {
        OutterClass.InnerClass innerClass = new OutterClass.InnerClass();
        innerClass.sayHi();
    }
}

/*********** 3、匿名内部类 **********/
class AnonymityTest {
    public static void main(String[] args) {
        AnonymityOutter anonymityOutter = new AnonymityOutter() {
            @Override
            public void hi() {
                System.out.println("Hi, AnonymityOutter.");
            }
        };
        anonymityOutter.hi();
    }
}

interface AnonymityOutter {
    void hi();
}

class EnumTest {
    public static void main(String[] args) {
        /*********** 枚举使用 **********/
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

/*********** 有参数枚举类 **********/
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

