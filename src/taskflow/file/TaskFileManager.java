package taskflow.file;

import taskflow.model.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskFileManager {

    private final String fileName = "tasks.txt";

    // ==============================
    // SAVE TASKS
    // ==============================

    public void saveTasks(List<Task> tasks) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName))) {

            for (Task task : tasks) {

                writer.write(
                        task.getId() + "|" +
                        task.getTitle() + "|" +
                        task.getDescription() + "|" +
                        task.getPriority() + "|" +
                        task.isCompleted()
                );

                writer.newLine();
            }

            System.out.println("Tasks saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving tasks.");
        }
    }

    // ==============================
    // LOAD TASKS
    // ==============================

    public List<Task> loadTasks() {

        List<Task> tasks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                // Ignore empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split("\\|", -1);

                // Every task must contain 5 pieces of data
                if (data.length != 5) {

                    System.out.println(
                            "Skipping invalid task data."
                    );

                    continue;
                }

                try {

                    int id = Integer.parseInt(data[0]);

                    String title = data[1];

                    String description = data[2];

                    String priority = data[3];

                    boolean completed =
                            Boolean.parseBoolean(data[4]);

                    Task task = new Task(
                            id,
                            title,
                            description,
                            priority
                    );

                    if (completed) {
                        task.markComplete();
                    }

                    tasks.add(task);

                } catch (Exception e) {

                    System.out.println(
                            "Skipping invalid task data."
                    );
                }
            }

            System.out.println(
                    tasks.size() + " task(s) loaded successfully."
            );

        } catch (FileNotFoundException e) {

            System.out.println(
                    "No saved tasks found. Starting with an empty task list."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error loading tasks."
            );
        }

        return tasks;
    }
}