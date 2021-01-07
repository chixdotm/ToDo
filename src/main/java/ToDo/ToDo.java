package ToDo;

import ToDo.repositories.ToDoFileRepository;
import ToDo.repositories.ToDoRepository;
import ToDo.services.ToDoService;
import ToDo.services.ToDoServiceImp;
import ToDo.controllers.ToDoController;
import ToDo.controllers.ToDoConsoleController;

public class ToDo {
    private ToDoRepository todoRepository;
    private ToDoService todoService;
    private ToDoController todoController;
    public static String file = Settings.STICKY_PATH;

//    public static final Gson GSON = new Gson();

    public ToDo() {
        todoRepository = new ToDoFileRepository(file, ";");
        todoService = new ToDoServiceImp(todoRepository);
        todoController = new ToDoConsoleController(todoService);
    }


    public static void main(String[] args) {

//        try {
//            File StickyNoteFile = new File(file);
//            StickyNoteFile.mkdirs();
//            if (StickyNoteFile.createNewFile()) {
//                System.out.println("File created: " + StickyNoteFile.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ToDo toDo = new ToDo();
        toDo.handleArgs(null);
        while (true) {
            String[] argsA = toDo.readFromConsole().split(" ");
            for (String str : argsA) {
                System.out.println("str:");
                System.out.println(str);
            }
            toDo.handleArgs(argsA);
        }


//        String firstNoteName = "First Note";
//        String firstTask = "1. Task";
//        String secondTask = "2. Push ToDo";
//
//        List<Task> notes = new ArrayList<>();
//        StickyNote firstNote = new StickyNote(firstNoteName);
//        notes.add(firstNote);
//
//        System.out.println("....notes: " + notes);
//        System.out.println("new: " + firstNote.toString());
//        System.out.println(firstNote.title);
//
//        System.out.println("addTask1: " + firstNote.addTask(firstNote, firstTask));
//        System.out.println("added: " + firstNote.toString());
//        System.out.println("addTask2: " + firstNote.addTask(firstNote, secondTask));
//        System.out.println("added: " + firstNote.toString());
//
//        String jsonNote = GSON.toJson(firstNote);
//        System.out.println("jsonNote: " + jsonNote);
//        StickyNote fromJsonNote = GSON.fromJson(jsonNote, StickyNote.class);
//        System.out.println("fromJSON: " + fromJsonNote);
//
//
//        try {
//            add(jsonNote);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void add(String newTask) throws IOException {
//        List<String> content = new ArrayList();
//        content.add(newTask);
//
//        Path filePath = Paths.get(FILENAME);
//        Files.write(filePath, content);
//    }
//
//    public static void read() throws IOException {
//        Path filePath = Paths.get(FILENAME);
//        List<String> lines = Files.readAllLines(filePath);
//        System.out.println("read(): " + lines.get(0));


    }

    public String readFromConsole() {
        String input = todoService.readFromConsole();
        return input;
    }

    public void handleArgs(String[] args) {
        todoController.handleToDoOperation(args);
    }
}

