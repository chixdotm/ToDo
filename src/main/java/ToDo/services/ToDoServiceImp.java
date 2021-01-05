package ToDo.services;

import ToDo.Settings;
import ToDo.models.StickyNote;
import ToDo.models.Task;
import ToDo.repositories.ToDoRepository;

import java.util.List;

public class ToDoServiceImp implements ToDoService {

    private ToDoRepository toDoRepository;

    public ToDoServiceImp(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public void printUsage() {
        System.out.println(Settings.USAGE);
    }

    @Override
    public void printToDoList() {
        StickyNote stickyNote = loadStickyNote();
        System.out.println(stickyNote);
        System.out.println("stickyNote:: " + stickyNote);
    }

    @Override
    public StickyNote addTask(List<String> taskStrings) {
        StickyNote stickyNote = loadStickyNote();
        List<Task> newTasks = toDoRepository.convertTasks(taskStrings);
        stickyNote.addTasks(newTasks);
        toDoRepository.save(stickyNote);
        System.out.println(tasksToPrint(toDoRepository.convertTasksToStringList(stickyNote.getTasks())));
        return stickyNote;
    }

    private String tasksToPrint(List<String> tasks) {
        StringBuilder sb = new StringBuilder();
        for (String task : tasks) {
            sb.append(task);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private StickyNote loadStickyNote() {
        return toDoRepository.readNotes();
    }
}
