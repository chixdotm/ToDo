package ToDo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class StickyNote {

    public String title;
    private List<Task> tasks;

    public StickyNote(String title, List<Task> newTasks) {
        this.title = title;
        tasks = new ArrayList<>();
        tasks.addAll(newTasks);
    }

    public StickyNote(String title) {
        this.title = title;
        tasks = new ArrayList<>();
    }

    public StickyNote(List<Task> tasks) {
        title = "new";
        this.tasks = tasks;

    }



    public void addTasks(List<Task> newTasks) {
        tasks.addAll(newTasks);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getTitle() {
        return title;
    }




//    public Task addTask(StickyNote note, String task) {
//        Task newTask = new Task(task);
//        note.tasks.add(newTask);
//        System.out.println("---newTask.task: " + newTask.task);
//        System.out.println("---tasks.get(0).toString: " + tasks.get(0).toString());
//        newTask.setDone(true);
//        System.out.println("---newTask.getDone: " + newTask.getDone());
//        newTask.setDue(1231);
//        System.out.println("---newTask.getDue: " + newTask.getDue());
//        System.out.println("---tasks.toString: " + tasks.toString());
//        System.out.println("---note.toString: " + note.toString());
//        System.out.println("---newTask.toString: " + newTask.toString());
//        for (Object temp : tasks) {
//            System.out.println(temp);
//        }
//        return newTask;
//    }


    @Override
    public String toString() {
        return "StickyNote{ title='" + title + '\'' +
                ", tasks=" + tasks +
                '}';

        //TODO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StickyNote that = (StickyNote) o;
        return getTitle().equals(that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
