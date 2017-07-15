package factory;

/**
 * Created by WQS on 2017/7/14.
 * Mail: 1027738387@qq.com
 * Github: https://github.com/wannibar
 */
public class Car implements Vehicle {
    @Override
    public void run() {
        System.out.println("Car is running");
    }
}
