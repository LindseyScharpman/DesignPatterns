package factory;

/**
 * Created by WQS on 2017/7/14.
 * Mail: 1027738387@qq.com
 * Github: https://github.com/wannibar
 */
public class FactoryTest {

    public static void main(String[] args) {

        // 只要换掉这个DeafaultFactory就可以换掉整套需求
        //AbstractFactory f = new DefaultFactory();
        AbstractFactory f = new MyFactory();
        f.createVehicle().run();
        f.createWeapon().doStuff();
    }
}
