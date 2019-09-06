package com.interview;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Lesson7_3 {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException {
        // 单例模式
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);   // output:true
        // 抽象工厂
        String result = (new CoffeeFactory()).createProduct("Latte");
        System.out.println(result); // output:拿铁
        //-------------- 观察者模式 START --------------
        // 定义发布者
        ConcreteSubject concreteSubject = new ConcreteSubject();
        // 定义订阅者
        ConcrereObserver concrereObserver = new ConcrereObserver("老王");
        ConcrereObserver concrereObserver2 = new ConcrereObserver("Java");
        // 添加订阅
        concreteSubject.attach(concrereObserver);
        concreteSubject.attach(concrereObserver2);
        // 发布信息
        concreteSubject.notify("更新了");
        //-------------- 观察者模式 END --------------
        // 装饰器模式
        LaoWang laoWang = new LaoWang();
        Jacket jacket = new Jacket(laoWang);
        Hat hat = new Hat(jacket);
        hat.show();
        // 模板方法模式
        Refrigerator refrigerator = new Banana();
        refrigerator.open();
        refrigerator.put();
        refrigerator.close();
        // 代理模式
        IAirTicket airTicket = new ProxyAirTicket();
        airTicket.buy();
        // 策略模式
        Trip trip = new Trip(new Bike());
        trip.doTrip();
        // 适配器模式
        TypeC typeC = new TypeC();
        MicroUSB microUSB = new AdapterMicroUSB(typeC);
        microUSB.charger();
    }
}

//------------- 适配器模式 START -------------
/*
 * 传统的充电线 MicroUSB
 */
interface MicroUSB {
    void charger();
}

/*
 * TypeC 充电口
 */
interface ITypeC {
    void charger();
}

class TypeC implements ITypeC {
    @Override
    public void charger() {
        System.out.println("TypeC 充电");
    }
}

/*
 * 适配器
 */
class AdapterMicroUSB implements MicroUSB {
    private TypeC typeC;

    public AdapterMicroUSB(TypeC typeC) {
        this.typeC = typeC;
    }

    @Override
    public void charger() {
        typeC.charger();
    }
}
//------------- 适配器模式 END -------------

//------------- 策略模式 START -------------
/*
 * 声明旅行
 */
interface ITrip {
    void going();
}

class Bike implements ITrip {
    @Override
    public void going() {
        System.out.println("骑自行车");
    }
}

class Drive implements ITrip {
    @Override
    public void going() {
        System.out.println("开车");
    }
}

/*
 * 出行类
 */
class Trip {
    private ITrip trip;

    public Trip(ITrip trip) {
        this.trip = trip;
    }

    public void doTrip() {
        this.trip.going();
    }
}
//------------- 策略模式 END -------------

//------------- 代理模式 START -------------
/*
 * 定义售票接口
 */
interface IAirTicket {
    void buy();
}

/*
 * 定义飞机场售票
 */
class AirTicket implements IAirTicket {
    @Override
    public void buy() {
        System.out.println("买票");
    }
}

/*
 * 代理售票平台
 */
class ProxyAirTicket implements IAirTicket {

    private AirTicket airTicket;

    public ProxyAirTicket() {
        airTicket = new AirTicket();
    }

    @Override
    public void buy() {
        airTicket.buy();
    }
}
//------------- 代理模式 END -------------

//------------- 模板方法模式 START -------------
abstract class Refrigerator {
    public void open() {
        System.out.println("开冰箱门");
    }

    public abstract void put();

    public void close() {
        System.out.println("关冰箱门");
    }
}

class Banana extends Refrigerator {

    @Override
    public void put() {
        System.out.println("放香蕉");
    }
}

class Apple extends Refrigerator {

    @Override
    public void put() {
        System.out.println("放苹果");
    }
}
//------------- 模板方法模式 END -------------

//------------- 装饰器模式 START -------------
// 顶级对象
interface IPerson {
    void show();
}

// 装饰器超类
class DecoratorBase implements IPerson {
    IPerson iPerson;

    public DecoratorBase(IPerson iPerson) {
        this.iPerson = iPerson;
    }

    @Override
    public void show() {
        iPerson.show();
    }
}

// 具体装饰器
class Jacket extends DecoratorBase {
    public Jacket(IPerson iPerson) {
        super(iPerson);
    }

    @Override
    public void show() {
        // 执行已有功能
        iPerson.show();
        System.out.println("穿上夹克");
    }
}

class Hat extends DecoratorBase {
    public Hat(IPerson iPerson) {
        super(iPerson);
    }

    @Override
    public void show() {
        // 执行已有功能
        iPerson.show();
        System.out.println("戴上帽子");
    }
}

// 具体对象
class LaoWang implements IPerson {
    @Override
    public void show() {
        System.out.println("什么都没穿");
    }
}
//------------- 装饰器模式 END -------------

//------------- 观察者模式 START -------------
// 观察者（消息接收方）
interface Observer {
    public void update(String message);
}

// 具体的观察者（消息接收方）
class ConcrereObserver implements Observer {
    private String name;

    public ConcrereObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "：" + message);
    }
}

// 被观察者（消息发布方）
interface Subject {
    // 增加订阅者
    public void attach(Observer observer);

    // 删除订阅者
    public void detach(Observer observer);

    // 通知订阅者更新消息
    public void notify(String message);
}

// 具体被观察者（消息发布方）
class ConcreteSubject implements Subject {
    // 订阅者列表（存储信息）
    private List<Observer> list = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        list.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : list) {
            observer.update(message);
        }
    }
}
//------------- 观察者模式 END -------------

// 抽象工厂
abstract class AbstractFactory {
    public abstract String createProduct(String product);
}

// 啤酒工厂
class BeerFactory extends AbstractFactory {
    @Override
    public String createProduct(String product) {
        String result = null;
        switch (product) {
            case "Hans":
                result = "汉斯";
                break;
            case "Yanjing":
                result = "燕京";
                break;
            default:
                result = "其他啤酒";
                break;
        }
        return result;
    }
}

// 咖啡工厂
class CoffeeFactory extends AbstractFactory {
    @Override
    public String createProduct(String product) {
        String result = null;
        switch (product) {
            case "Mocca":
                result = "摩卡";
                break;
            case "Latte":
                result = "拿铁";
                break;
            default:
                result = "其他咖啡";
                break;
        }
        return result;
    }
}

// 简单工厂
class Factory {
    public static String createProduct(String product) {
        String result = null;
        switch (product) {
            case "Mocca":
                result = "摩卡";
                break;
            case "Latte":
                result = "拿铁";
                break;
            default:
                result = "其他";
                break;
        }
        return result;
    }
}

// 单例模式
class Singleton {
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}

// 单例模式-延迟加载
class SingletonLazy {
    private static SingletonLazy instance;

    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}

