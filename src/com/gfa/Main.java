package com.gfa;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            File toDoFile = new File("todo.txt");
            if (toDoFile.createNewFile()) {
                System.out.println("File created: " + toDoFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            add("newtask");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void add(String newTask) throws IOException {
        List<String> content = new ArrayList();
        content.add("second line of my file");

        Path filePath = Paths.get("todo.txt");
        Files.write(filePath, content);

        return;
    }
}
