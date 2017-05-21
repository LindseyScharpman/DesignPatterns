package command;

import java.util.ArrayList;
import java.util.List;

public class Boy {

    List<Command> cmds = new ArrayList<>();

    public void add(Command c) {
        cmds.add(c);
    }

    public void remove(Command c) {
        cmds.remove(c);
    }

    public void execute() {
        cmds.forEach(Command::execute);
    }

    public void undo() {
        cmds.forEach(Command::undo);
    }
}
