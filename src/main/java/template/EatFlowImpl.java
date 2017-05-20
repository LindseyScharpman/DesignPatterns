package template;

public class EatFlowImpl implements AbstractFlowInterface {

    @Override
    public void action1() {
        System.out.println("action 1");
    }

    @Override
    public void action2() {
        System.out.println("action 2");
    }

    @Override
    public void action3() {
        System.out.println("action 3");
    }

    public static void main(String[] args) {
        EatFlowImpl flow = new EatFlowImpl();
        flow.execute();
    }
}
