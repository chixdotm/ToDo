package com.gfa;

public class Item {

    public String task;
    public Boolean isDone;
    public int due;

    public Item(String task) {
        this.task = task;
        this.isDone = false;
        this.due = 0;
    }

    @Override
    public String toString() {
        return task;
    }
}