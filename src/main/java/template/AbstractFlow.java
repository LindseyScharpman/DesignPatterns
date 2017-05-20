package template;

public abstract class AbstractFlow {

    public void execute() {
        action1();
        action2();
        action3();
    }

    public abstract void action1();

    public abstract void action2();

    public abstract void action3();
}
