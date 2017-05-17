package singleton;

import java.io.Serializable;

public class Singleton2 implements Serializable {

    // 构造器设置成private避免直接new
    // 当然通过反射可以new,可以通过一个标志来标记下,如果出现第二次new抛出异常
    private Singleton2() {
    }

    // 如果可以序列化,那么反序列化时仍然返回该INSTANCE
    protected Object readResolve() {
        return HOLDER.INSTANCE;
    }

    private static class HOLDER {
        // 设置成static保证该类的INSTANCE类变量只有一个
        // 把INSTANCE放到类里面,只有用到时候才会加载
        public static Singleton2 INSTANCE = new Singleton2();
    }

    // 只有调用该方法时候才会去初始化INSTANCE
    public static Singleton2 getInstance() {
        return HOLDER.INSTANCE;
    }
}
