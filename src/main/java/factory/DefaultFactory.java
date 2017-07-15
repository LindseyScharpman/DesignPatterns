package factory;

/**
 * Created by WQS on 2017/7/14.
 * Mail: 1027738387@qq.com
 * Github: https://github.com/wannibar
 */
public class DefaultFactory implements AbstractFactory {

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }
}
