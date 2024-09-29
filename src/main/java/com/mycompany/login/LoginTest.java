/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

import java.util.Scanner;

/**
 *
 * @author south
 */

public class LoginTest {

    public static void main(String[] args) {
       
        // Create an instance of the Login class to access user registration and login functionality
        Login system = new Login();
        // Initialize the Scanner to capture user input from the console
        Scanner sc = new Scanner(System.in);

           // Keep asking for valid account creation details using a while loop
        boolean isAccountCreated = false;

        System.out.println("Hi, please create an account");

        while (!isAccountCreated) {
            //Prompts for firstname
            System.out.print("Enter first name: ");
            String firstName = sc.nextLine();
            system.setFirstName(firstName);
            
            //Prompts for last name
            System.out.print("Enter last name: ");
            String lastName = sc.nextLine();
            system.setLastName(lastName);
            
            //prompts for the username and requirements
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            system.setUsername(username);
            
            //prompts for the password and requirements
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            system.setPassword(password);

            
        // If Statements to check the username and password meet the required criteria
            String registrationStatus = system.registerUser();
            System.out.println(registrationStatus);  // Display registration status

            if (registrationStatus.contains("successfully")) {
                // If both the username and password are valid, then create the account
                system.CreatAccount(username, password, firstName, lastName);
                isAccountCreated = true;
            }
        }
 // Proceed to login if account creation is successful
    System.out.println("Login:");

// Initialize loginStatus as false to start the loop
    boolean loginStatus = false;

// Keep prompting for username and password until login is successful
    while (!loginStatus) {
    System.out.print("Enter username: ");
    String loginUsername = sc.nextLine();

    System.out.print("Enter password: ");
    String loginPassword = sc.nextLine();

    // Attempt login
    loginStatus = system.loginUser(loginUsername, loginPassword);

    // Display login status message
    String loginMessage = system.returnLoginStatus(loginStatus);
    System.out.println(loginMessage);
}
    }
}