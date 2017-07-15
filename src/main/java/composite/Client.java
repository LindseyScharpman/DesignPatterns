package composite;

import java.awt.*;
import java.awt.Component;

public class Client {

    public static void main(String[] args) {
        Leaf a = new ALeaf();
        Leaf b = new BLeaf();
        // c1必须是Composite,因为这样才能添加Component
        Composite c1 = new Composite();
        c1.add(a);
        c1.add(b);

        Composite c2 = new Composite();
        c2.add(c1);
        c2.add(new Leaf());

        c2.doStuff();

    }
}

