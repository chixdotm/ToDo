package ToDo.services;

import ToDo.models.StickyNote;

import java.util.List;

public interface ToDoService {

    void printUsage();

    void printToDoList();

    StickyNote addTask(List<String> toDoStrings);

}
