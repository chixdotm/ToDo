package com.gfa;

import java.util.ArrayList;
import java.util.List;


public class StickyNote {


    public String title;
    public List<Object> tasks = new ArrayList<>();

    public StickyNote(String title) {
        this.title = title;
    }


    public Item addItem(StickyNote note, String task) {
        Item item = new Item(task);
        note.tasks.add(item);
        System.out.println("---addItem------start");
        System.out.println("---item.task: " + item.task);
        System.out.println("---tasks.get(0).toString: " + tasks.get(0).toString());
        System.out.println("---tasks.toString: " + tasks.toString());
        System.out.println("---note.toString: " + note.toString());
        System.out.println("---item.toString: " + item.toString());
        System.out.println("---addItem------end");
        return item;
    }


    @Override
    public String toString() {
        return "StickyNote{ title='" + title + '\'' +
                ", tasks=" + tasks +
                '}';
    }


}

