package command;

public class KneelingPad implements Command{
    @Override
    public void execute() {
        System.out.println("跪键盘去哼");
    }

    @Override
    public void undo() {
        System.out.println("可怜可怜你，别跪键盘了^_^");
    }
}
