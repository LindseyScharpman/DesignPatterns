package command;

public class Girl {

    Boy boy;

    public Girl(Boy boy) {
        this.boy = boy;
    }

    public void askBoyDoStuff() {
        boy.execute();
    }

    public void askBoyUndoStuff() {
        boy.undo();
    }

    public static void main(String[] args) {
        Boy boy = new Boy();
        boy.add(new GiveMoney());
        boy.add(new KneelingPad());
        Girl girl = new Girl(boy);
        girl.askBoyDoStuff();
        System.out.println("=====小姐姐后悔了====");
        girl.askBoyUndoStuff();
    }
}
