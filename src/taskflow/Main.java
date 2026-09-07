package taskflow;

import taskflow.manager.TaskManager;
import taskflow.ui.ConsoleUI;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        // Load previously saved tasks
        manager.loadTasks();

        ConsoleUI ui = new ConsoleUI(manager);

        ui.start();

        // Save tasks before exiting
        manager.saveTasks();
    }
}