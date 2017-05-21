package composite;

public class Leaf implements Component {
    @Override
    public void doStuff() {
        System.out.println("默认实现....");
    }
}
