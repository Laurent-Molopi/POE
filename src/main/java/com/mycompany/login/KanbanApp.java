/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.login;
import javax.swing.JOptionPane;

public class KanbanApp {

    public static void main(String[] args) {
        Login system = new Login();
        boolean isAccountCreated = false;

        JOptionPane.showMessageDialog(null, "Hi, please create an account");

        while (!isAccountCreated) {
            // Prompts for first name with exit check
            String firstName = JOptionPane.showInputDialog("Enter first name:");
            if (firstName == null) exitApp();  // Exit if "Cancel" or "X" is clicked
            system.setFirstName(firstName);

            // Prompts for last name with exit check
            String lastName = JOptionPane.showInputDialog("Enter last name:");
            if (lastName == null) exitApp();
            system.setLastName(lastName);

            // Prompts for username with exit check
            String username = JOptionPane.showInputDialog("Enter username:");
            if (username == null) exitApp();
            system.setUsername(username);

            // Prompts for password with exit check
            String password = JOptionPane.showInputDialog("Enter password:");
            if (password == null) exitApp();
            system.setPassword(password);

            // Check account creation status
            String registrationStatus = system.registerUser();
            JOptionPane.showMessageDialog(null, registrationStatus);

            if (registrationStatus.contains("Username successfully captured") && registrationStatus.contains("Password successfully captured")) {
                system.createAccount(username, password, firstName, lastName);
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
            loginStatus = system.loginUser(loginUsername, loginPassword);
            String loginMessage = system.returnLoginStatus(loginStatus);
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
        String numTasksString = JOptionPane.showInputDialog("How many tasks do you want to add?");
        if (numTasksString == null) exitApp();

        int numTasks = Integer.parseInt(numTasksString);
        Task[] tasks = new Task[numTasks];
        int totalDuration = 0;

        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            if (taskName == null) exitApp();

            String taskDescription = JOptionPane.showInputDialog("Enter task description (less than 50 characters):");
            if (taskDescription == null) exitApp();
            while (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                taskDescription = JOptionPane.showInputDialog("Enter task description:");
                if (taskDescription == null) exitApp();
            }

            String developerDetails = JOptionPane.showInputDialog("Enter developer's full name:");
            if (developerDetails == null) exitApp();

            int taskDuration = -1;
            while (taskDuration < 0) {
                try {
                    String durationString = JOptionPane.showInputDialog("Enter task duration (hours):");
                    if (durationString == null) exitApp();

                    taskDuration = Integer.parseInt(durationString);
                    if (taskDuration < 0) {
                        JOptionPane.showMessageDialog(null, "Task duration must be a positive number.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for task duration.");
                }
            }

            String[] statusOptions = {"To Do", "Doing", "Done"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Choose task status", "Task Status",
                    JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
            if (taskStatus == null) exitApp();

            Task task = new Task(taskName, i, taskDescription, developerDetails, taskDuration, taskStatus);
            tasks[i] = task;
            totalDuration += task.returnTotalHours();

            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }
        JOptionPane.showMessageDialog(null, "Total task duration: " + totalDuration + " hours");
    }

    // Method to exit the application
    private static void exitApp() {
        JOptionPane.showMessageDialog(null, "Goodbye!");
        System.exit(0);
    }
}
