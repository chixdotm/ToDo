package ToDo.services;

import ToDo.models.StickyNote;

import java.io.File;
import java.util.List;

public interface ToDoService {

    void printUsage();

    void printToDoList();

    StickyNote addTask(List<String> toDoStrings);

    void stop();

    StickyNote newStickyNote(String name);

    void saveSticky(String name);

    void createSticky(String name);

    void readSticky(File folder);

}
