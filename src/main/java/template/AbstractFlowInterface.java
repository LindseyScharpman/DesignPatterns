package template;

public interface AbstractFlowInterface {

    default public void execute() {
        action1();
        action2();
        action3();
    }

    void action1();

    void action2();

    void action3();
}
