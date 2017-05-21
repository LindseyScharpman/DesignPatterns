package command;

public class GiveMoney implements Command {
    @Override
    public void execute() {
        System.out.println("给小姐姐发红包...");
    }

    @Override
    public void undo() {
        System.out.println("可怜可怜你,把红包给你...");
    }
}
