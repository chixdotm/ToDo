package ToDo.repositories;

import ToDo.models.StickyNote;
import ToDo.models.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDoFileRepository implements ToDoRepository {

    private Path filePath;
    private String separator;

    public ToDoFileRepository(String file, String separator) {
        this.filePath = Paths.get(file);
        this.separator = separator;
    }

    @Override
    public StickyNote readNotes() {
        try {

            System.out.println("filePath:: " + filePath);

            List<String> taskStrings = Files.readAllLines(filePath);
            List<Task> tasks = convertTasks(taskStrings);

            System.out.println("tasks:: " + tasks);

            return new StickyNote("new", tasks);
        } catch (IOException e) {
            System.err.println("Unable to read file.");
            return null;
        }
    }

    @Override
    public List<Task> convertTasks(List<String> taskStrings) {

        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < taskStrings.size(); i++) {
            String[] taskData = taskStrings.get(i).split(separator);
            String text = taskData[0];
            tasks.add(new Task(text));
        }

        return tasks;


    }

    @Override
    public List<String> convertTasksToStringList(List<Task> tasks) {
        List<String> taskStrings = new ArrayList<>();
        for (Task task : tasks) {
            StringBuilder sb = new StringBuilder();
            sb.append(task.getTask());
            taskStrings.add(sb.toString());
        }
        return taskStrings;
    }

    @Override
    public void save(StickyNote stickyNote) {
        List<String> taskStrings = convertTasksToStringList(stickyNote.getTasks());
        try {
            Files.write(filePath, taskStrings);
        } catch (IOException e) {
            System.err.println("Unable to write file.");
        }

    }
}
