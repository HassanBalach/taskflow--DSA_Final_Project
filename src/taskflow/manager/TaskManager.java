package taskflow.manager;

import taskflow.ds.MyLinkedList;
import taskflow.ds.MyStack;
import taskflow.ds.MyQueue;
import taskflow.file.TaskFileManager;
import taskflow.model.Task;

import java.util.List;

public class TaskManager {

    private MyLinkedList<Task> tasks;
    private MyStack<Task> undoStack;
    private MyQueue<Task> taskQueue;
    private TaskFileManager fileManager;

    // ==============================
    // CONSTRUCTOR
    // ==============================

    public TaskManager() {

        tasks = new MyLinkedList<>();
        undoStack = new MyStack<>();
        taskQueue = new MyQueue<>();
        fileManager = new TaskFileManager();
    }

    // ==============================
    // SAVE TASKS
    // ==============================

    public void saveTasks() {

        fileManager.saveTasks(tasks.toArrayList());
    }

    // ==============================
    // LOAD TASKS
    // ==============================

    public void loadTasks() {

        List<Task> loadedTasks = fileManager.loadTasks();

        for (Task task : loadedTasks) {

            if (!tasks.containsId(task.getId())) {

                tasks.add(task);
            }
        }
    }

    // ==============================
    // ADD TASK
    // ==============================

    public boolean addTask(Task task) {

        if (task == null) {

            return false;
        }

        if (tasks.containsId(task.getId())) {

            return false;
        }

        tasks.add(task);

        return true;
    }

    // ==============================
    // VIEW ALL TASKS
    // ==============================

    public void showAllTasks() {

        if (tasks.toArrayList().isEmpty()) {

            System.out.println("No tasks found.");

            return;
        }

        System.out.println(
                "ID | TITLE | DESCRIPTION | PRIORITY | STATUS"
        );

        System.out.println(
                "------------------------------------------------"
        );

        tasks.display();
    }

    // ==============================
    // SEARCH TASK
    // ==============================

    public void searchTask(int id) {

        Task task = tasks.findById(id);

        if (task != null) {

            System.out.println("\nTask Found:");
            System.out.println("------------------------------");
            System.out.println("ID: " + task.getId());
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Priority: " + task.getPriority());
            System.out.println(
                    "Status: " +
                    (task.isCompleted() ? "COMPLETED" : "PENDING")
            );

        } else {

            System.out.println("Task not found.");
        }
    }

    // ==============================
    // UPDATE TASK
    // ==============================

    public void updateTask(
            int id,
            String title,
            String description,
            String priority) {

        Task task = tasks.findById(id);

        if (task == null) {

            System.out.println("Task not found.");

            return;
        }

        task.setTitle(title);
        task.setDescription(description);
        task.setPriority(priority);

        System.out.println("Task updated successfully.");
    }

    // ==============================
    // DELETE TASK
    // ==============================

    public void deleteTask(int id) {

        Task task = tasks.findById(id);

        if (task == null) {

            System.out.println("Task not found.");

            return;
        }

        boolean deleted = tasks.deleteById(id);

        if (deleted) {

            // Store deleted task in Stack
            // so it can be restored using Undo
            undoStack.push(task);

            System.out.println("Task deleted successfully.");
        }
    }

    // ==============================
    // COMPLETE TASK
    // ==============================

    public void completeTask(int id) {

        Task task = tasks.findById(id);

        if (task == null) {

            System.out.println("Task not found.");

            return;
        }

        if (task.isCompleted()) {

            System.out.println("Task is already completed.");

            return;
        }

        task.markComplete();

        System.out.println("Task marked as completed.");
    }

    // ==============================
    // SORT BY PRIORITY
    // ==============================

    public void sortByPriority() {

        tasks.sortByPriority();

        System.out.println("Tasks sorted by priority.");
    }

    // ==============================
    // SORT BY ID
    // ==============================

    public void sortById() {

        tasks.sortById();

        System.out.println("Tasks sorted by ID.");
    }

    // ==============================
    // UNDO
    // ==============================

    public void undo() {

        Task task = undoStack.pop();

        if (task == null) {

            System.out.println("Nothing to undo.");

            return;
        }

        tasks.add(task);

        System.out.println("Undo successful.");
        System.out.println("Restored Task:");
        System.out.println(task);
    }

    // ==============================
    // ADD TASK TO QUEUE
    // ==============================

    public void addToQueue(int id) {

        Task task = tasks.findById(id);

        if (task == null) {

            System.out.println("Task not found.");

            return;
        }

        taskQueue.enqueue(task);

        System.out.println(
                "Task added to processing queue."
        );
    }

    // ==============================
    // PROCESS NEXT TASK
    // ==============================

    public void processNextTask() {

        Task task = taskQueue.dequeue();

        if (task == null) {

            System.out.println("Queue is empty.");

            return;
        }

        System.out.println("Processing Task:");
        System.out.println(task);
    }
}