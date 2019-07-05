package com.interview;

abstract class AbstractAnimal {
    public AbstractAnimal() {
        System.out.println("Init AbstractAnimal.");
    }

    protected static String animalName = "AbstractAnimal";

    abstract void eat();

    public void run() {
        System.out.println("AbstractAnimal Run.");
    }
}

class AbstractAnimalInstance extends AbstractAnimal {
    public static void main(String[] args) {
        AbstractAnimal animal = new AbstractAnimalInstance();
        animal.run();
        System.out.println(animalName);
        animal.eat();
    }

    @Override
    void eat() {
        System.out.println("AbstractAnimalInstance Eat.");
    }
}

//@FunctionalInterface
interface IAnimal {
    static String animalName = "Animal Name";

    static void printSex() {
        System.out.println("Male Dog");
    }

    default void printAge() {
        System.out.println("18");
    }

    void run(String name);
}

//class FunctionInterfaceTest {
//    public static void main(String[] args) {
//        IAnimal animal = name -> System.out.println(name);
//        animal.run("WangWang");
//    }
//}

class AnimalImpl implements IAnimal {
    static String animalName = new String("Animal Name");

    public static void main(String[] args) {
        System.out.println(IAnimal.animalName == animalName);
    }

    @Override
    public void run(String name) {
        System.out.println("AnimalImpl：" + name);
    }
}
