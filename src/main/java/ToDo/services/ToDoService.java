package ToDo.services;

import ToDo.models.StickyNote;

import java.io.File;
import java.util.List;

public interface ToDoService {

    void printUsage();

    void printStickyNote(String name);

    StickyNote addTask(String name, List<String> toDoStrings);

    void stop();

    void createStickyFile(String name);

    void ListStickyFiles(File folder);

    String readFromConsole();

}
