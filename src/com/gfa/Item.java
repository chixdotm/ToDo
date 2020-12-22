package com.gfa;

import java.util.ArrayList;
import java.util.List;


public class Item {

    public String task;
    public Boolean isDone;
    public int due;

    public Item(String task) {
        this.task = task;
        this.isDone = false;
        this.due = 0;
    }

    public String toString() {
        return task;
    }
}