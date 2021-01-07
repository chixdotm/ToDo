package ToDo.repositories;

import ToDo.Settings;
import ToDo.models.StickyNote;
import ToDo.models.Task;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ToDoFileRepository implements ToDoRepository {

    private final Path filePath;
    private String separator;
    public static final Gson GSON = new Gson();
    public String stickyDir = Settings.STICKY_PATH;

    public ToDoFileRepository(String file, String separator) {
        this.filePath = Paths.get(file);
        this.separator = separator;
    }

    @Override
    public StickyNote createNotes(String name) {
        return new StickyNote(name);
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
    public String convertStickyToJSON(StickyNote stickyNote) {
        String jsonNote = GSON.toJson(stickyNote);
        System.out.println("jsonNote: " + jsonNote);
        return jsonNote;
    }

    @Override
    public StickyNote convertJSONToSticky(String jsonNote) {
        StickyNote fromJsonNote = GSON.fromJson(jsonNote, StickyNote.class);
        System.out.println("fromJSON: " + fromJsonNote);
        return fromJsonNote;
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

    @Override
    public void saveSticky(StickyNote stickyNote) {
        String name = stickyNote.getTitle();
        System.out.println(name);
    }

    @Override
    public void createStickyFile(String name) {
        try {
            File StickyFile = new File(stickyDir + name + ".txt");
            File path = new File(stickyDir);
            if (path.mkdirs()) {
                System.out.println("dir created: " + path);
            }
            if (StickyFile.createNewFile()) {
                System.out.println("File created: " + StickyFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public StickyNote ListStickyFiles(File file) {
        for (final File fileEntry : Objects.requireNonNull(file.listFiles())) {
            if (fileEntry.isDirectory()) {
                ListStickyFiles(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
        return null;
    }

    @Override
    public StickyNote readNotes(String name) {
        String File = stickyDir + name + ".txt";
        System.out.println("File: " + File);
        Path path = Paths.get(File);
        try {
            List<String> taskStrings = Files.readAllLines(path);
            System.out.println("taskStrings: " + taskStrings.toString());
            List<Task> tasks = convertTasks(taskStrings);
            System.out.println("tasks:: " + tasks);
            return new StickyNote(name, tasks);
        } catch (IOException e) {
            System.err.println("Unable to read file.");
            return null;
        }
    }
//    @Override
//    public StickyNote readSticky(File file) {
//        File path = new File(stickyDir);
//        System.out.println("readSticky:");
//        for (final File fileEntry : file.listFiles()) {
//            System.out.println(fileEntry.getName());
//            if (fileEntry.isDirectory()) {
//                System.out.println("isDir");
//                System.out.println(fileEntry);
//                readSticky(fileEntry);
//            } else {
//                System.out.println("notDir");
//                System.out.println(fileEntry.getName());
//            }
//        }
//        return null;

//    }
}
