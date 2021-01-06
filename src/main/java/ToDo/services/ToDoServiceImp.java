package ToDo.services;

import ToDo.Settings;
import ToDo.models.StickyNote;
import ToDo.models.Task;
import ToDo.repositories.ToDoRepository;

import java.io.File;
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
    public void printToDoList(String name) {
        StickyNote stickyNote = loadStickyNote(name);
        System.out.println(stickyNote);
        System.out.println("stickyNote:: " + stickyNote);
    }

    @Override
    public StickyNote addTask(String name, List<String> taskStrings) {
        StickyNote stickyNote = loadStickyNote(name);
        List<Task> newTasks = toDoRepository.convertTasks(taskStrings);
        stickyNote.addTasks(newTasks);
        toDoRepository.save(stickyNote);
        System.out.println(tasksToPrint(toDoRepository.convertTasksToStringList(stickyNote.getTasks())));
        return stickyNote;
    }

    @Override
    public void stop() {
        System.exit(0);
    }

    @Override
    public StickyNote newStickyNote(String name) {
        return null;
    }

    @Override
    public void saveSticky(String name) {
        StickyNote stickyNote = new StickyNote(name);
        toDoRepository.saveSticky(stickyNote);
    }

    @Override
    public void createSticky(String name) {
        toDoRepository.createSticky(name);
    }

    @Override
    public void readSticky(File folder) {
        toDoRepository.readSticky(folder);
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

    private StickyNote loadStickyNote(String name) {
        return toDoRepository.readNotes(name);
    }


}
