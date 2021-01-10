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

    public ToDo() {
        todoRepository = new ToDoFileRepository(file, ";");
        todoService = new ToDoServiceImp(todoRepository);
        todoController = new ToDoConsoleController(todoService);
    }

    public static void main(String[] args) {
        ToDo toDo = new ToDo();
        toDo.handleArgs(null);
        while (true) {
            String[] argsA = toDo.readFromConsole().split(" ");
            toDo.handleArgs(argsA);
        }
    }

    public String readFromConsole() {
        return todoService.readFromConsole();
    }

    public void handleArgs(String[] args) {
        todoController.handleToDoOperation(args);
    }
}

