package adapter;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

// MyLib通过组合方式适配了类库1和类库2
// 当然也可以采用继承,但是这里类库都是final所以只能组合
public class MyLib {
    private Lib1 lib1;
    private Lib2 lib2;

    public MyLib(Lib1 lib1, Lib2 lib2) {
        this.lib1 = lib1;
        this.lib2 = lib2;
    }

    public void doStuff() {
        lib1.doStuff1();
        System.out.println("我的类库....");
        lib2.doStuff2();
    }

    public static void main(String[] args) {
        new MyLib(new Lib1(), new Lib2()).doStuff();
    }
}
