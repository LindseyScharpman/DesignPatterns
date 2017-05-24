package observer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EventDriven {

    List<Listener> observers = new ArrayList<>();

    public void registerListener(Listener listener) {
        observers.add(listener);
    }

    public void fireKeyPress() {
        Event e = new Event("key press");
        for (Listener listener : observers)
            if (listener instanceof KeyEventListener)
                listener.doStuff(e);
    }

    public void fireButtonPress() {
        Event e = new Event("button press");
        for (Listener listener : observers)
            if (listener instanceof ButtonListener)
                listener.doStuff(e);
    }

    public static void main(String[] args) {
        EventDriven ed = new EventDriven();
        ed.registerListener(new KeyEventListener());
        ed.registerListener(new KeyEventListener());
        ed.registerListener(new ButtonListener());
        ed.registerListener(new ButtonListener());
        ed.registerListener(new ButtonListener());

        //ed.fireButtonPress();
        ed.fireKeyPress();
    }
}

interface Listener {
    void doStuff(Event e);
}

class Event {
    String name;

    public Event(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Event{" + "name='" + name + '\'' + '}';
    }
}

class KeyEventListener implements Listener {
    @Override
    public void doStuff(Event e) {
        System.out.println(e + ":key pressed");
    }
}

class ButtonListener implements Listener {
    @Override
    public void doStuff(Event e) {
        System.out.println(e + ":buttion pressed");
    }
}


