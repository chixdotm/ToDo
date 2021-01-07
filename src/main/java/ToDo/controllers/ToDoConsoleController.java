package ToDo.controllers;

import ToDo.Settings;
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
        System.out.println("operation.length: ");
        String operator = (operation == null || operation.length == 0) ?
                null : operation[0];
        List<String> params = (operation == null || operation.length == 0) ?
                null : Arrays.asList(Arrays.copyOfRange(operation, 1, operation.length));

        System.out.println("operator: " + operator);
        System.out.println("params: " + params);

        if (!(params == null)) {
        int length = operation.length;
            System.out.println(length);
            for (String tmp : params) {
                System.out.println("tmp: " + tmp);
            }
            System.out.println(params.get(0));
        }


        if (operation == null || operation.length == 0 || operator.equals(Settings.USAGE_OPERATION)) {
            toDoService.printUsage();


        } else if (operator.equals(Settings.LIST_OPERATION) && operation.length > 1) {
            toDoService.printToDoList(params.get(0));


        } else if (operator.equals(Settings.EXIT_OPERATION)) {
            toDoService.stop();

        } else if (operator.equals(Settings.CREATE_STICKY_FILE_OPERATION) && operation.length > 1) {
            toDoService.createStickyFile(params.toString());

        } else if (operator.equals(Settings.ADD_OPERATION) && operation.length > 1) {
            System.out.println("StickyNote?");
            String name = toDoService.readFromConsole();
            toDoService.addTask(name, params);

//        } else if (operator.equals(Settings.NEW_STICKY_OPERATION) && operation.length > 1) {
//            toDoService.newStickyNote(params.toString());

        } else if (operator.equals(Settings.LIST_STICKY_FILES_OPERATION)) {
//            File filePath = new File("Sticky/");
            System.out.println(filePath.toString());
            toDoService.ListStickyFiles(filePath);

//        } else if (operator.equals(Settings.WRITE_OPERATION) && operation.length > 1) {
//            toDoService.saveSticky(params.toString());

        } else {
            System.out.println("Not good!");
            toDoService.printUsage();
        }
    }
}

