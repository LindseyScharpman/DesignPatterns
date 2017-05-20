package template;

public class EatFlow extends AbstractFlow {
    @Override
    public void action1() {
        System.out.println("买菜");
    }

    @Override
    public void action2() {
        System.out.println("炒菜");
    }

    @Override
    public void action3() {
        System.out.println("洗碗");
    }

    public static void main(String[] args) {
        AbstractFlow flow = new EatFlow();
        flow.execute();
    }
}
