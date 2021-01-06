package ToDo.repositories;

import ToDo.models.StickyNote;
import ToDo.models.Task;

import java.io.File;
import java.util.List;

public interface ToDoRepository {

    StickyNote readNotes(String name);

    StickyNote createNotes(String name);

    List<Task> convertTasks(List<String> taskStrings);

    List<String> convertTasksToStringList(List<Task> tasks);

    String convertStickyToJSON(StickyNote stickyNote);

    StickyNote convertJSONToSticky(String jsonNote);

    void save(StickyNote stickyNote);

    void saveSticky(StickyNote stickyNote);

    void createSticky(String name);

    StickyNote readSticky(File folder);

}
