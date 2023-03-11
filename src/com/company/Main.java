package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code her
        Editor e = new Editor();
        e.write("Hello ");
        e.write("World ");
        e.write("Memento Pattern ");
        e.undo();
        e.undo();
        e.undo();
        e.redo();
        ///out World
        System.out.println(e.getText());
    }
}
