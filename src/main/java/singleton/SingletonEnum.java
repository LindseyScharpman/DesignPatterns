package singleton;

import java.io.Serializable;

// 使用枚举类型,天然安全
// 而且避免了通过反射调用构造器
public enum SingletonEnum implements Serializable {
    INSTANCE("sigleton");

    private String name;

    SingletonEnum(String name) {
        this.name = name;
    }

    public void doSomething() {
        System.out.println("do some stuff");
    }

    public String getName() {
        return name;
    }
}
