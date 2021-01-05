package ToDo.repositories;

import ToDo.models.StickyNote;
import ToDo.models.Task;
import java.util.List;

public interface ToDoRepository {

    StickyNote readNotes();

    List<Task> convertTasks(List<String> taskStrings);

    List<String> convertTasksToStringList(List<Task> tasks);

    void save(StickyNote stickyNote);




}
