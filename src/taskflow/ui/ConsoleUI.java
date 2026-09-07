package taskflow.ui;

import java.util.Scanner;

import taskflow.manager.TaskManager;
import taskflow.model.Task;

public class ConsoleUI {

    private TaskManager manager;
    private Scanner scanner;

    public ConsoleUI(TaskManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        boolean running = true;

        while (running) {

            showMenu();

            int choice = readInt("Choose an option: ");

            switch (choice) {

                case 1 -> addTask();

                case 2 -> viewTasks();

                case 3 -> searchTask();

                case 4 -> updateTask();

                case 5 -> deleteTask();

                case 6 -> completeTask();

                case 7 -> sortTasks();

                case 8 -> undoTask();

                case 9 -> addTaskToQueue();

                case 10 -> processNextTask();

                case 11 -> {
                    running = false;
                    System.out.println("\nExiting TaskFlow. Goodbye!");
                }

                default -> System.out.println(
                        "\nInvalid option. Please choose between 1 and 11."
                );
            }

            if (running) {

                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    // ==============================
    // MAIN MENU
    // ==============================

    private void showMenu() {

        System.out.println();
        System.out.println("==============================");
        System.out.println("           TASKFLOW");
        System.out.println("==============================");
        System.out.println("1.  Add Task");
        System.out.println("2.  View All Tasks");
        System.out.println("3.  Search Task");
        System.out.println("4.  Update Task");
        System.out.println("5.  Delete Task");
        System.out.println("6.  Complete Task");
        System.out.println("7.  Sort Tasks");
        System.out.println("8.  Undo");
        System.out.println("9.  Add Task to Queue");
        System.out.println("10. Process Next Task");
        System.out.println("11. Exit");
        System.out.println("==============================");
    }

    // ==============================
    // ADD TASK
    // ==============================

    private void addTask() {

        System.out.println("\n===== ADD TASK =====");

        int id = readPositiveInt("Task ID: ");

        String title = readRequiredText("Title: ");

        String description = readRequiredText("Description: ");

        String priority = readPriority();

        Task task = new Task(
                id,
                title,
                description,
                priority
        );

        boolean added = manager.addTask(task);

        if (added) {

            System.out.println("\nTask added successfully.");

        } else {

            System.out.println("\nTask ID already exists.");
        }
    }

    // ==============================
    // VIEW TASKS
    // ==============================

    private void viewTasks() {

        System.out.println("\n===== ALL TASKS =====");

        manager.showAllTasks();
    }

    // ==============================
    // SEARCH TASK
    // ==============================

    private void searchTask() {

        System.out.println("\n===== SEARCH TASK =====");

        int id = readPositiveInt("Enter Task ID: ");

        manager.searchTask(id);
    }

    // ==============================
    // UPDATE TASK
    // ==============================

    private void updateTask() {

        System.out.println("\n===== UPDATE TASK =====");

        int id = readPositiveInt("Enter Task ID: ");

        String title = readRequiredText("New title: ");

        String description = readRequiredText("New description: ");

        String priority = readPriority();

        manager.updateTask(
                id,
                title,
                description,
                priority
        );
    }

    // ==============================
    // DELETE TASK
    // ==============================

    private void deleteTask() {

        System.out.println("\n===== DELETE TASK =====");

        int id = readPositiveInt("Enter Task ID: ");

        manager.deleteTask(id);
    }

    // ==============================
    // COMPLETE TASK
    // ==============================

    private void completeTask() {

        System.out.println("\n===== COMPLETE TASK =====");

        int id = readPositiveInt("Enter Task ID: ");

        manager.completeTask(id);
    }

    // ==============================
    // SORT TASKS
    // ==============================

    private void sortTasks() {

        System.out.println("\n===== SORT TASKS =====");

        System.out.println("1. Sort by Priority");
        System.out.println("2. Sort by ID");
        System.out.println("3. Back");

        int choice = readInt("Choose an option: ");

        switch (choice) {

            case 1 -> {

                manager.sortByPriority();

                System.out.println("\n===== SORTED BY PRIORITY =====");

                manager.showAllTasks();
            }

            case 2 -> {

                manager.sortById();

                System.out.println("\n===== SORTED BY ID =====");

                manager.showAllTasks();
            }

            case 3 -> {

                System.out.println("\nGoing back...");
            }

            default -> {

                System.out.println(
                        "\nInvalid option. Please choose between 1 and 3."
                );
            }
        }
    }

    // ==============================
    // UNDO
    // ==============================

    private void undoTask() {

        System.out.println("\n===== UNDO =====");

        manager.undo();
    }

    // ==============================
    // ADD TASK TO QUEUE
    // ==============================

    private void addTaskToQueue() {

        System.out.println("\n===== ADD TO QUEUE =====");

        int id = readPositiveInt("Enter Task ID: ");

        manager.addToQueue(id);
    }

    // ==============================
    // PROCESS NEXT TASK
    // ==============================

    private void processNextTask() {

        System.out.println("\n===== PROCESS TASK =====");

        manager.processNextTask();
    }

    // ==============================
    // INTEGER INPUT
    // ==============================

    private int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(scanner.nextLine().trim());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a valid number."
                );
            }
        }
    }

    // ==============================
    // POSITIVE INTEGER INPUT
    // ==============================

    private int readPositiveInt(String message) {

        while (true) {

            int number = readInt(message);

            if (number > 0) {

                return number;
            }

            System.out.println(
                    "Task ID must be greater than 0."
            );
        }
    }

    // ==============================
    // REQUIRED TEXT INPUT
    // ==============================

    private String readRequiredText(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {

                return input;
            }

            System.out.println(
                    "This field cannot be empty."
            );
        }
    }

    // ==============================
    // PRIORITY INPUT
    // ==============================

    private String readPriority() {

        while (true) {

            System.out.print(
                    "Priority (LOW/MEDIUM/HIGH): "
            );

            String priority = scanner.nextLine()
                    .trim()
                    .toUpperCase();

            if (priority.equals("LOW") ||
                priority.equals("MEDIUM") ||
                priority.equals("HIGH")) {

                return priority;
            }

            System.out.println(
                    "Invalid priority. Please enter LOW, MEDIUM, or HIGH."
            );
        }
    }
}