package ToDo.controllers;

import ToDo.Settings;
import ToDo.repositories.ToDoRepository;
import ToDo.services.ToDoService;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ToDoConsoleController implements ToDoController {


    private ToDoService toDoService;
    private File filePath = new File(Settings.STICKY_PATH);

    public ToDoConsoleController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }


    @Override
    public void handleToDoOperation(String[] operation) {
        String operator = (operation == null || operation.length == 0) ?
                null : operation[0];

        List<String> params = (operation == null || operation.length == 0) ?
                null : Arrays.asList(Arrays.copyOfRange(operation, 1, operation.length));

        if (operation == null || operation.length == 0 || operator.equals(Settings.USAGE_OPERATION)) {
            toDoService.printUsage();
        } else if (operator.equals(Settings.LIST_OPERATION)) {
            toDoService.printToDoList();
        } else if (operator.equals(Settings.EXIT_OPERATION)) {
            toDoService.stop();
        } else if (operator.equals(Settings.CREATE_STICKY_OPERATION) && operation.length > 1) {
            toDoService.createSticky(params.toString());
        } else if (operator.equals(Settings.ADD_OPERATION) && operation.length > 1) {
            toDoService.addTask(params);
        } else if (operator.equals(Settings.NEW_STICKY_OPERATION) && operation.length > 1) {
            toDoService.newStickyNote(params.toString());
        } else if (operator.equals(Settings.LIST_STICKY_OPERATION)) {
//            File filePath = new File("Sticky/");
            System.out.println(filePath.toString());
            toDoService.readSticky(filePath);


        } else if (operator.equals(Settings.WRITE_OPERATION) && operation.length > 1) {
            toDoService.saveSticky(params.toString());
        } else {
            System.out.println("Not good!");
            toDoService.printUsage();
        }

    }

}

