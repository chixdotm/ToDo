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


    public List<Task> getTasks() {
        return tasks;
    }

    public String getTitle() {
        return title;
    }

    public void addTasks(List<Task> newTasks) {
        tasks.addAll(newTasks);
    }

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
