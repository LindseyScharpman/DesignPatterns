package observer;

import java.util.Observable;
import java.util.Observer;

public class MyObservable extends  Observable
{

    public static void main( String[] args )
    {
        MyObservable observable = new MyObservable();   // 被观察对象
        observable.addObserver( new MyObserver1() );
        observable.addObserver( new MyObserver2() );

        observable.setChanged();
        observable.notifyObservers( new EventObj( "hello" ) );

    }
}


// 观察者,被通知的对象1
class MyObserver1 implements Observer
{

    @Override
    public void update( Observable o, Object arg )
    {
        System.out.println( "1:" + o + ":" + arg );
    }
}

// 观察者,被通知的对象2
class MyObserver2 implements Observer
{

    @Override
    public void update( Observable o, Object arg )
    {
        System.out.println( "2:" + o + ":" + arg );
    }
}


class EventObj
{
    String name;

    public EventObj( String name )
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "EventObj{" +
                "name='" + name + '\'' +
                '}';
    }
}
