package ToDo.models;

public class Task {

    public String task;
    private Boolean isDone;
    private int due;

    public Task(String task) {
        this.task = task;
        this.isDone = false;
        this.due = 0;
    }

    public void setDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public void setDue(int due) {
        this.due = due;
    }

    public String getTask() {
        return task;
    }

    public Boolean getDone() {
        return isDone;
    }

    public int getDue() {
        return due;
    }

    @Override
    public String toString() {
        return task;
    }


}