package ToDo.controllers;

import ToDo.Settings;
import ToDo.repositories.ToDoRepository;
import ToDo.services.ToDoService;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ToDoConsoleController implements ToDoController {


    private ToDoService toDoService;
    private File filePath = new File(Settings.STICKY_PATH);

    public ToDoConsoleController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }


    @Override
    public void handleToDoOperation(String[] operation) {

//        if (operation == null) {
//            System.out.println("args:");
//            Scanner in = new Scanner(System.in);
//            String arg = in.nextLine();
//            String[] argsA = arg.split(" ");
//            handleToDoOperation(argsA);
//        }


        String operator = (operation == null || operation.length == 0) ?
                null : operation[0];

        List<String> params = (operation == null || operation.length == 0) ?
                null : Arrays.asList(Arrays.copyOfRange(operation, 1, operation.length));

        System.out.println("operator: " + operator);
        System.out.println("params: " + params);
        System.out.println("params0: " + params);
        System.out.println("operator: " + operator);


        if (operation == null || operation.length == 0 || operator.equals(Settings.USAGE_OPERATION)) {
            toDoService.printUsage();
        } else if (operator.equals(Settings.LIST_OPERATION) && operation.length > 1) {
            toDoService.printToDoList(params.toString());
        } else if (operator.equals(Settings.EXIT_OPERATION)) {
            toDoService.stop();
        } else if (operator.equals(Settings.CREATE_STICKY_OPERATION) && operation.length > 1) {
            toDoService.createSticky(params.toString());
        } else if (operator.equals(Settings.ADD_OPERATION) && operation.length > 1) {
            toDoService.addTask(params.toString(), params);

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

