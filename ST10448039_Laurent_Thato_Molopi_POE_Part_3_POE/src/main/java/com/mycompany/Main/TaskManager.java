/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Main;
import java.util.ArrayList;

/**
 *
 * @author south
 */
public class TaskManager {
  private ArrayList<String> developers = new ArrayList<>();
    private ArrayList<String> taskNames = new ArrayList<>();
    private ArrayList<String> taskIDs = new ArrayList<>();
    private ArrayList<Integer> taskDurations = new ArrayList<>();
    private ArrayList<String> taskStatuses = new ArrayList<>();

    public ArrayList<String> getDevelopers() {
        return developers;
    }

    public ArrayList<String> getTaskNames() {
        return taskNames;
    }

    public ArrayList<String> getTaskIDs() {
        return taskIDs;
    }

    public ArrayList<Integer> getTaskDurations() {
        return taskDurations;
    }

    public ArrayList<String> getTaskStatuses() {
        return taskStatuses;
    }

    public void addTask(Task task) {
        developers.add(task.getDeveloperDetails());
        taskNames.add(task.getTaskName());
        taskIDs.add(task.createTaskID(task.getTaskName(), taskNames.size() - 1, task.getDeveloperDetails()));
        taskDurations.add(task.getTaskDuration());
        taskStatuses.add(task.getTaskStatus());
    }

    public String displayCompletedTasks() {
        StringBuilder completedTasks = new StringBuilder("Completed Tasks:\n");
        for (int i = 0; i < taskStatuses.size(); i++) {
            if ("Done".equalsIgnoreCase(taskStatuses.get(i))) {
                completedTasks.append("Developer: ").append(developers.get(i))
                              .append(", Task Name: ").append(taskNames.get(i))
                              .append(", Duration: ").append(taskDurations.get(i)).append(" hours\n");
            }
        }
        return completedTasks.toString();
    }

    public String displayLongestTask() {
        int maxIndex = 0;
        for (int i = 1; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > taskDurations.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return "Longest Task:\nDeveloper: " + developers.get(maxIndex) +
               ", Task Name: " + taskNames.get(maxIndex) +
               ", Duration: " + taskDurations.get(maxIndex) + " hours";
    }

    public String searchTaskByName(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                return "Task Found:\nDeveloper: " + developers.get(i) +
                       ", Task Name: " + taskNames.get(i) +
                       ", Status: " + taskStatuses.get(i);
            }
        }
        return "Task not found.";
    }

    public String searchTasksByDeveloper(String developer) {
        StringBuilder tasksByDeveloper = new StringBuilder("Tasks for Developer: " + developer + "\n");
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developer)) {
                tasksByDeveloper.append("Task Name: ").append(taskNames.get(i))
                                .append(", Status: ").append(taskStatuses.get(i)).append("\n");
            }
        }
        return tasksByDeveloper.length() > 0 ? tasksByDeveloper.toString() : "No tasks found for developer.";
    }

    public String deleteTaskByName(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                developers.remove(i);
                taskNames.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                return "Task '" + taskName + "' deleted successfully.";
            }
        }
        return "Task not found.";
    }

    public String displayAllTasks() {
        StringBuilder allTasks = new StringBuilder("All Tasks:\n");
        for (int i = 0; i < taskNames.size(); i++) {
            allTasks.append("Developer: ").append(developers.get(i))
                    .append(", Task Name: ").append(taskNames.get(i))
                    .append(", Task ID: ").append(taskIDs.get(i))
                    .append(", Duration: ").append(taskDurations.get(i)).append(" hours")
                    .append(", Status: ").append(taskStatuses.get(i)).append("\n");
        }
        return allTasks.toString();
        
    }
}
