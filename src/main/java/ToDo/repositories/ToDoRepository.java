package ToDo.repositories;

import ToDo.models.StickyNote;
import ToDo.models.Task;

import java.io.File;
import java.util.List;

public interface ToDoRepository {

    StickyNote readJSONStickyFile(String name);

    List<Task> convertTasksToTaskList(List<String> taskStrings);

    List<String> convertTasksToStringList(List<Task> tasks);

    String convertStickyToJSON(StickyNote stickyNote);

    StickyNote convertJSONToSticky(String jsonNote);

    void saveJSON(StickyNote stickyNote);

    void createStickyFile(String name);

    StickyNote ListStickyFiles(File folder);

}
