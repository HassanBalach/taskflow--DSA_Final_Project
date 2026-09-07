package taskflow.model;

public class Task {

    private int id;
    private String title;
    private String description;
    private String priority;
    private boolean completed;

    public Task(int id, String title, String description, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void markComplete() {
        completed = true;
    }

    @Override
    public String toString() {

        String status = completed ? "COMPLETED" : "PENDING";

        return id + " | " +
               title + " | " +
               description + " | " +
               priority + " | " +
               status;
    }
}