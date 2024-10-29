/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

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
    
    // Constructor and other necessary methods...
    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();  // Automatically generate the TaskID when creating a Task
    }
    // Ensures task description is <= 50 characters
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }
   public String createTaskID() {
        String taskNamePrefix = taskName.substring(0, 2).toUpperCase();
        String developerSuffix = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskNamePrefix + ":" + taskNumber + ":" + developerSuffix;
    }


    // Return task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + taskDuration + " hours";
    }

    // Return total hours
    public int returnTotalHours() {
        return taskDuration;
    }
}
