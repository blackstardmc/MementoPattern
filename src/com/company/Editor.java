package com.company;

import java.util.ArrayList;
import java.util.List;

public class Editor {
    private final Caretaker caretaker;
    private String text;

    public Editor() {
        this.text = "";
        this.caretaker = new Caretaker();
        caretaker.saveMemento(new Memento(this.text));
    }

    public void write(String text) {
        this.text += text;
        caretaker.saveMemento(new Memento(this.text));

    }

    public void undo() {
        Memento memento = caretaker.getBeforeMemento();
        if (memento != null) {
            this.text = memento.getText();
        }
    }

    public void redo() {
        Memento memento = caretaker.getAfterMemento();
        if (memento != null) {
            this.text = memento.getText();
        }
    }

    public String getText() {
        return text;
    }


}

class Memento {
    private final String text;

    Memento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}


class Caretaker {
    private final List<Memento> mementos;
    private int index;

    public Caretaker() {
        mementos = new ArrayList<Memento>();
        index = -1;
    }

    public void saveMemento(Memento memento) {
        mementos.add(memento);
        index++;
    }

    public Memento getBeforeMemento() {
        if (index > 0) {
            index--;
            return mementos.get(index);
        }
        return null;
    }

    public Memento getAfterMemento() {
        if (index < mementos.size() - 1) {
            index++;
            return mementos.get(index);
        }
        return null;
    }
}



