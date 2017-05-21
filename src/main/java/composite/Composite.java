package composite;

import java.util.ArrayList;
import java.util.List;

// 复合组件
public class Composite implements Component {

    List<Component> components = new ArrayList<>();

    @Override
    public void doStuff() {
        for (Component c : components)
            c.doStuff();
    }

    public void add(Component c) {
        components.add(c);
    }

    public void remove(Component c) {
        components.remove(c);
    }
}
