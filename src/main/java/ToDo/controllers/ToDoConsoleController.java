package ToDo.controllers;

import ToDo.Settings;
import ToDo.services.ToDoService;

import java.util.Arrays;
import java.util.List;

public class ToDoConsoleController implements ToDoController {


    private ToDoService toDoService;

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
            System.exit(0);
        } else if (operator.equals(Settings.ADD_OPERATION) && operation.length > 1) {
            toDoService.addTask(params);
        } else {
            System.out.println("Not good!");
            toDoService.printUsage();
        }


    }


}

