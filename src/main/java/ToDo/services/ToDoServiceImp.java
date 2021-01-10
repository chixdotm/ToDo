package ToDo.services;

import ToDo.Settings;
import ToDo.models.StickyNote;
import ToDo.models.Task;
import ToDo.repositories.ToDoRepository;

import java.io.File;
import java.util.List;
import java.util.Scanner;

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
    public void printStickyNote(String name) {
        StickyNote stickyNote = loadStickyNote(name);
        System.out.println(stickyNote);
    }

    @Override
    public StickyNote addTask(String name, List<String> taskStrings) {
        StickyNote stickyNote = loadStickyNote(name);
        System.out.println("loaded Sticky: " + stickyNote);
        List<Task> newTasks = toDoRepository.convertTasksToTaskList(taskStrings);
        stickyNote.addTasks(newTasks);
        toDoRepository.saveJSON(stickyNote);
        System.out.println(tasksToPrint(toDoRepository.convertTasksToStringList(stickyNote.getTasks())));
        return stickyNote;
    }

    @Override
    public void stop() {
        System.exit(0);
    }

    @Override
    public void createStickyFile(String name) {
        toDoRepository.createStickyFile(name);
    }

    @Override
    public void ListStickyFiles(File folder) {
        toDoRepository.ListStickyFiles(folder);
    }

    @Override
    public String readFromConsole() {
        System.out.println("input:");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
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
        return toDoRepository.readJSONStickyFile(name);
    }
}
