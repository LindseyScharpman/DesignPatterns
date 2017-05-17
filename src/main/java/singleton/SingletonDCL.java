package singleton;

public class SingletonDCL {

    // volatile禁止被重排序
    private volatile static SingletonDCL INSTANCE;

    private SingletonDCL() {
    }

    public static SingletonDCL getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonDCL.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDCL();
                    return INSTANCE;
                }
            }
        }
        return INSTANCE;
    }
}
