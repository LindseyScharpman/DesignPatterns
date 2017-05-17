package singleton;

import java.io.Serializable;

public class Singleton1 implements Serializable {

    // 设置成static保证该类的INSTANCE类变量只有一个
    private static Singleton1 INSTANCE = new Singleton1();

    // 构造器设置成private避免直接new
    // 当然通过反射可以new,可以通过一个标志来标记下,如果出现第二次new抛出异常
    private Singleton1() {
    }

    // 如果可以序列化,那么反序列化时仍然返回该INSTANCE
    protected Object readResolve() {
        return INSTANCE;
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
