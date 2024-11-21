/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Main;
/**
 *
 * @author south
 */
public class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    public boolean checkTaskDescription(String description) {
        // Ensures task description is 50 characters or fewer
        return description.length() <= 50;
    }

    public String createTaskID(String taskName, int taskNumber, String developerDetails) {
        // Generates Task ID using the specified format
        String taskNamePart = taskName.substring(0, 2).toUpperCase();
        String developerPart = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskNamePart + ":" + taskNumber + ":" + developerPart;
    }

    public void setTaskDetails(String taskName, String taskDescription, String developerDetails,
                                int taskDuration, String taskStatus, int taskNumber) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskNumber = taskNumber;
        this.taskID = createTaskID(taskName, taskNumber, developerDetails);
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus +
               "\nDeveloper Details: " + developerDetails +
               "\nTask Number: " + taskNumber +
               "\nTask Name: " + taskName +
               "\nTask Description: " + taskDescription +
               "\nTask ID: " + taskID +
               "\nDuration: " + taskDuration + " hours";
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }
}
