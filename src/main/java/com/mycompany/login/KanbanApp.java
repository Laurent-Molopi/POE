/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.login;
import javax.swing.JOptionPane;

public class KanbanApp {

    public static void main(String[] args) {
        Login Kanban = new Login();
        boolean isAccountCreated = false;

        JOptionPane.showMessageDialog(null, "Hi, please create an account");

        while (!isAccountCreated) {
            // Prompts for first name with exit check
            String firstName = JOptionPane.showInputDialog("Enter first name:");
            if (firstName == null) exitApp();  // Exit if "Cancel" or "X" is clicked
            Kanban.setFirstName(firstName);

            // Prompts for last name with exit check
            String lastName = JOptionPane.showInputDialog("Enter last name:");
            if (lastName == null) exitApp();
            Kanban.setLastName(lastName);

            // Prompts for username with exit check
            String username = JOptionPane.showInputDialog("Enter username:");
            if (username == null) exitApp();
            Kanban.setUsername(username);

            // Prompts for password with exit check
            String password = JOptionPane.showInputDialog("Enter password:");
            if (password == null) exitApp();
            Kanban.setPassword(password);

            // Check account creation status
            String registrationStatus = Kanban.registerUser();
            JOptionPane.showMessageDialog(null, registrationStatus);

            if (registrationStatus.contains("Username successfully captured") && registrationStatus.contains("Password successfully captured")) {
                Kanban.createAccount(username, password, firstName, lastName);
                isAccountCreated = true;
            }
        }

        // Login process
        boolean loginStatus = false;
        JOptionPane.showMessageDialog(null, "Please Login:");

        while (!loginStatus) {
            // Prompt for username with exit check
            String loginUsername = JOptionPane.showInputDialog("Enter username:");
            if (loginUsername == null) exitApp();

            // Prompt for password with exit check
            String loginPassword = JOptionPane.showInputDialog("Enter password:");
            if (loginPassword == null) exitApp();

            // Attempt login
            loginStatus = Kanban.loginUser(loginUsername, loginPassword);
            String loginMessage = Kanban.returnLoginStatus(loginStatus);
            JOptionPane.showMessageDialog(null, loginMessage);
        }

        // Once logged in, proceed to the Kanban task management system
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        boolean running = true;
        while (running) {
            String option = JOptionPane.showInputDialog("Choose an option:\n1) Add Task\n2) Show Report\n3) Quit");

            if (option == null) exitApp();

            switch (option) {
                case "1":
                    addTasks();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose 1, 2, or 3.");
            }
        }
    }

  // Method to add tasks
    public static void addTasks() {
    // Prompt the user to enter the number of tasks to add
    String numTasksString = JOptionPane.showInputDialog("How many tasks do you want to add?");
    if (numTasksString == null) exitApp();  // Exit if the user cancels

    int numTasks = Integer.parseInt(numTasksString);  // Convert input to integer
    Task[] tasks = new Task[numTasks];  // Array to store task objects
    int totalDuration = 0;  // Initialize total duration counter

    int i = 0;  // Task index counter
    do {
        // Prompt for task name
        String taskName = JOptionPane.showInputDialog("Enter task name:");
        if (taskName == null) exitApp();  // Exit if the user cancels

        // Prompt for task description, ensuring it is under 50 characters
        String taskDescription;
        do {
            taskDescription = JOptionPane.showInputDialog("Enter task description (less than 50 characters):");
            if (taskDescription == null) exitApp();  // Exit if the user cancels
            if (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
            }
        } while (taskDescription.length() > 50);  // Loop until valid description length is provided

        // Prompt for developer details
        String developerDetails = JOptionPane.showInputDialog("Enter developer's full name:");
        if (developerDetails == null) exitApp();  // Exit if the user cancels

        // Prompt for task duration, ensuring it is a positive integer
        int taskDuration;
        do {
            String durationString = JOptionPane.showInputDialog("Enter task duration (hours):");
            if (durationString == null) exitApp();  // Exit if the user cancels

            try {
                taskDuration = Integer.parseInt(durationString);  // Parse the duration input
                if (taskDuration < 0) {
                    JOptionPane.showMessageDialog(null, "Task duration must be a positive number.");
                }
            } catch (NumberFormatException e) {  // Handle invalid input
                JOptionPane.showMessageDialog(null, "Please enter a valid number for task duration.");
                taskDuration = -1;  // Reset task duration for loop continuation
            }
        } while (taskDuration < 0);  // Loop until a valid positive duration is provided

        // Prompt for task status selection from predefined options
        String[] statusOptions = {"To Do", "Doing", "Done"};
        String taskStatus = (String) JOptionPane.showInputDialog(null, "Choose task status", "Task Status",
                JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
        if (taskStatus == null) exitApp();  // Exit if the user cancels

        // Create a new Task object and add it to the tasks array
        Task task = new Task(taskName, i, taskDescription, developerDetails, taskDuration, taskStatus);
        tasks[i] = task;  // Store task in the array
        totalDuration += task.returnTotalHours();  // Accumulate total duration

        // Display task details to the user
        JOptionPane.showMessageDialog(null, task.printTaskDetails());

        i++;  // Move to the next task
    } while (i < numTasks);  // Loop until all tasks are added

    // Display the total duration for all tasks
    JOptionPane.showMessageDialog(null, "Total task duration: " + totalDuration + " hours");
}
    // Method to exit the application
    private static void exitApp() {
        JOptionPane.showMessageDialog(null, "Goodbye!");
        System.exit(0);
    }
}
